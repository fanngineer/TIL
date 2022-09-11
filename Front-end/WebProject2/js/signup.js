const signupForm = document.getElementById("signup-form");
const floatingInputId = document.getElementById("floatingInputId");
const floatingInputName = document.getElementById("floatingInputName");
const floatingInputEmail = document.getElementById("floatingInputEmail");
const floatingPassword = document.getElementById("floatingPassword");
const floatingPasswordConfirm = document.getElementById(
    "floatingPasswordConfirm"
);
const registBtn = document.getElementById("regist-btn");
const cancelBtn = document.getElementById("cancel-btn");

registBtn.addEventListener("click", (event) => {
    let validationCheck = true;
    let userListStr = JSON.parse(localStorage.getItem("user"))

    let userList = [];
    if(userListStr){
        userListStr.forEach(ele => {
            userList.push(ele);
        })
    }

    if(floatingInputId.value.length < 6){
        alert("ID가 너무 짧습니다. 6글자 이상으로 작성하세요.")
        return;
    }

    userList.forEach(ele =>{
        if(floatingInputId.value === ele.id){
            alert("이미 등록된 ID 입니다.");
            return;
        }
    })

    if(floatingPassword.value.length < 8){
        alert("비밀번호가 너무 짧습니다. 8글자 이상으로 작성하세요.")
        return;
    }
    
    if(floatingPassword.value !== floatingPasswordConfirm.value){
        alert("비밀번호가 일치하지 않습니다.")
        return;
    }
    
    if (validationCheck) {
        let temp = {
            id: floatingInputId.value,
            name: floatingInputName.value,
            email: floatingInputEmail.value,
            password: floatingPassword.value,
        };
        userList.push(temp);
        localStorage.setItem("user", JSON.stringify(userList));
        alert("회원가입 완료!");
        window.location = `/signin.html?q=${0}`
    } else {
        alert("작성이 제대로 되지 않았습니다.");
    }
});


cancelBtn.addEventListener("click", e =>{
    window.location = `/signin.html?q=${0}`
})
