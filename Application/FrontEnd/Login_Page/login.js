document.addEventListener("DOMContentLoaded", function () {
   // const loginForm = document.getElementById("loginForm");
    const loginButton = document.getElementById("loginbtn");
    const loginResult = document.getElementById("loginResult");

    // Assuming your XML file is named "users.xml"
    const xmlFile = "cred.xml";

    loginButton.addEventListener("click", function () {
        const username = document.getElementById("un").value;
        const password = document.getElementById("psw").value;

        // Load and parse the XML file to check user credentials
        const xhr = new XMLHttpRequest();
        xhr.open("GET", xmlFile, true);

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const xmlData = xhr.responseXML;
                if (xmlData) {
                    const users = xmlData.getElementsByTagName("user");

                    for (let i = 0; i < users.length; i++) {
                        const storedUsername = users[i].getElementsByTagName("Username")[0].textContent;
                        const storedPassword = users[i].getElementsByTagName("Password")[0].textContent;
                        const storedType = users[i].getElementsByTagName("Type")[0].textContent;


                        if (username === storedUsername && password === storedPassword) {
                            //loginResult.innerHTML = "Login successful!";
                            //return;
                            if(storedType == "Admin" )
                            {
                            window.location.href="../Admin_Page/admin.html"
                            }
                            else if(storedType == "Member")
                            {
                            window.location.href="../Member_Screen/index.html"
                            }
                            else if(storedType == "Manager")
                            {
                                window.location.href="../Manager_page/manager1.html"
                            }
                            else{
                                loginResult.innerHTML = "Incorrect values"
                            }
                        }
                        else{
                            loginResult.innerHTML = "Invalid username or password!! Enter Correct Values";
                        }
                    }

                    // If no matching user found
                    
                } else {
                    loginResult.innerHTML = "Error loading user data.";
                }
            }
        };

        xhr.send();
    });
});


function gotoimportusers()
{
    window.location.href="../Import_User_new/Import_User.html"
}