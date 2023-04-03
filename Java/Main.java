package org.example;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Main {

    private final static String PRIVATE_KEY = "48a69d98cedd612700b3226b776bdd27d5781551aec9f3bcffd8f443e5458399";

    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(3000000);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(0);

    private final static String RECIPIENT = "0x57797247B1f7108408f77D84cD25f45c32e4728C";

    private final static String CONTRACT_ADDRESS = "0x91fA0054B72846925f35cf5eAD758CD7BaE9f88F";

    public static void main(String[] args) {
        try {
            new Main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Main() throws Exception {
        String tokenuri = "https://example.com/token1";
        //1.
        Web3j web3j = Web3j.build(new HttpService("https://rpc.ssafy-blockchain.com"));
        Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
        System.out.println(web3ClientVersion.getWeb3ClientVersion());
        //2.
        Credentials credentials = getCredentialsFromPrivateKey();
        //3.
        String abi = "[{\"constant\":false,\"inputs\":[{\"name\":\"tokenURI\",\"type\":\"string\"},{\"name\":\"to\",\"type\":\"address\"}],\"name\":\"create\",\"outputs\":[{\"name\":\"newItemId\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"}]";


        Function createFunction = new Function(
                "create",
                Arrays.asList(new Address(RECIPIENT), new Utf8String("https://example.com/token1") ),
                Arrays.asList(new TypeReference<Uint256>() {
                })
        );
        //nounce
        EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(
                credentials.getAddress(), DefaultBlockParameterName.LATEST).sendAsync().get();
        BigInteger nonce = ethGetTransactionCount.getTransactionCount();
        //
        TransactionManager transactionManager = new RawTransactionManager(web3j, credentials);
        //
        RawTransaction rawTransaction = RawTransaction.createTransaction(
                nonce, GAS_PRICE, GAS_LIMIT, CONTRACT_ADDRESS, FunctionEncoder.encode(createFunction));
        byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        String hexValue = Numeric.toHexString(signedMessage);
        EthSendTransaction ethSendTransaction = web3j.ethSendRawTransaction(hexValue).sendAsync().get();
        String transactionHash = ethSendTransaction.getTransactionHash();
        System.out.println("---------------------------------------");
        System.out.println(transactionHash);
        //
        Thread.sleep(5000);
        List<Type> decode = FunctionReturnDecoder.decode(ethSendTransaction.getResult(),
                createFunction.getOutputParameters());
        System.out.println("tokenId : " + decode.get(0).getTypeAsString());
        EthGetTransactionReceipt transactionReceipt = web3j.ethGetTransactionReceipt(transactionHash).send();
        if (transactionReceipt.getTransactionReceipt().isPresent()) {
            // 9
            System.out.println("transactionReceipt.getResult().getContractAddress() = " +
                    Long.decode(transactionReceipt.getResult().getLogs().get(0).getTopics().get(3)) );
        } else {
            System.out.println("transaction complete not yet");
            System.out.println("transaction complete not yet");
        }
    }

    private void printWeb3Version(Web3j web3j) {
        Web3ClientVersion web3ClientVersion = null;
        try {
            web3ClientVersion = web3j.web3ClientVersion().send();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String web3ClientVersionString = web3ClientVersion.getWeb3ClientVersion();
        System.out.println("Web3 client version: " + web3ClientVersionString);
    }

    private Credentials getCredentialsFromWallet() throws IOException, CipherException {
        return WalletUtils.loadCredentials(
                "passphrase",
                "wallet/path"
        );
    }

    private Credentials getCredentialsFromPrivateKey() {
        return Credentials.create(PRIVATE_KEY);
    }

    private void transferEthereum(Web3j web3j, Credentials credentials) throws Exception {
        TransactionManager transactionManager = new RawTransactionManager(
                web3j,
                credentials
        );

        Transfer transfer = new Transfer(web3j, transactionManager);

        TransactionReceipt transactionReceipt = transfer.sendFunds(
                RECIPIENT,
                BigDecimal.ONE,
                Convert.Unit.ETHER,
                GAS_PRICE,
                GAS_LIMIT
        ).send();

        System.out.print("Transaction = " + transactionReceipt.getTransactionHash());
    }


}