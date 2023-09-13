document.addEventListener("DOMContentLoaded", function () {
  const loadDataButton = document.getElementById("loadDataButton");
  const userDataDiv = document.getElementById("userData");

  loadDataButton.addEventListener("click", function () {
      // Make an XMLHttpRequest to the server to fetch the XML data
      const xhr = new XMLHttpRequest();
      xhr.open("GET", "data.xml", true);

      xhr.onreadystatechange = function () {
          if (xhr.readyState === 4 && xhr.status === 200) {
              const xmlData = xhr.responseXML;
              if (xmlData) {
                  const users = xmlData.getElementsByTagName("user");
                  let userDataHTML = '<table border="1 px solid">';
                  userDataHTML += '<tr>'
                  userDataHTML += '<th  border="1 px solid" text-align = "center"><strong>Name:</strong></th>';
                  userDataHTML += '<th  border="1 px solid " text-align = "center"><strong>Email:</strong></th>';
                  userDataHTML += '<th border="1 px solid" text-align = "center"><strong>Phone:</strong></th>';
                  userDataHTML += '<th  border="1 px solid" text-align = "center"><strong>Role:</strong></th>';
                  userDataHTML += '</tr>';

                  for (let i = 0; i < users.length; i++) {
                      const name = users[i].getElementsByTagName("Name")[0].textContent;
                      const email = users[i].getElementsByTagName("Email")[0].textContent;
                      const phone = users[i].getElementsByTagName("Phone")[0].textContent;
                      const role = users[i].getElementsByTagName("Role")[0].textContent;
                      userDataHTML += '<tr>';
                      userDataHTML += '<td border="1 px solid" text-align = "center">'+name+'</td>'; 
                      userDataHTML += '<td border="1 px solid" text-align = "center">'+email+'</td>';
                      userDataHTML += '<td border="1 px solid" text-align = "center">'+phone+'</td>';
                      userDataHTML += '<td border="1 px solid" text-align = "center">'+role+'</td>';
                      userDataHTML += '</tr>'
                  }

                  userDataHTML += '</table>';
                  userDataDiv.innerHTML = userDataHTML;
              } else {
                  userDataDiv.innerHTML = "Error loading data.";
              }
          }
      };

      xhr.send();
  });
});
