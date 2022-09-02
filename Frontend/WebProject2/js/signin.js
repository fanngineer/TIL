const signupForm = document.getElementById("signup-form");
        const floatingInputId = document.getElementById("floatingInputId");
        const floatingPassword = document.getElementById("floatingPassword");

        const loginBtn = document.getElementById("login-btn");
        const cancelBtn = document.getElementById("cancel-btn");

        loginBtn.addEventListener("click", event =>{
            let userListStr = JSON.parse(localStorage.getItem("user"))
            let userList = [];
            if(userListStr){
                userListStr.forEach(ele => {
                    userList.push(ele);
                })
            }
            for(let i=0;i<userList.length;i++){
                if(userList[i].id === floatingInputId.value){
                    if(userList[i].password === floatingPassword.value){
                        alert("로그인 성공");
                        window.location = "/index.html"
                        return;
                    } 
                } 
            }
            alert("로그인 실패")

            floatingPassword.value = "";

        })

        cancelBtn.addEventListener("click", e =>{
            window.location = `/index.html`
        })