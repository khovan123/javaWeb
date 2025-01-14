<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String result = (String) request.getAttribute("result");
    if (result == null) {
        result = "";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Calculator</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            li {
                display: flex;
                align-items: center;
                cursor: pointer;
                padding: 5px 10px;
                border-radius: 5px;
            }

            li.active {
                background-color: #5045E5;
                box-shadow: 0 0 10px #5045E5;
            }

            .inputForm input {
                background-color: #374151;
                border: none;
                border-radius: 5px;
                padding: 10px;
                color: #fff;
                font-size: 16px;
            }

            .form {
            }

            input:focus {
                outline: none;
            }

            button:hover{
                background-color:#4338CA !important;
            }

            .cal button.active{
                background-color:#4338CA !important;
            }

        </style>
    </head>
    <body style="margin: 0;overflow: hidden;">
        <section style="color: #fff;height: 100vh;display: flex;flex-direction: column;justify-content: center;align-items: center;">
            <h2 style="color: #5045E5;">Calculator</h2>
            <div style="display: flex;justify-content: center; align-items: stretch;gap:32px;padding-bottom: 64px;">
                <div style="width:350px;background-color: #1F2937;border-radius: 10px;">
                    <div class="cal" style="display: flex;align-items: center;">
                        <button style="width: 50%; font-size: 24px; font-weight: 700; background-color: #374151;color: #fff;border-top-left-radius: 10px;border:none;padding: 10px;border-right: 1px solid #5045E5; ">S</button>
                        <button style="width: 50%; font-size: 24px; font-weight: 700; background-color: #374151;color: #fff;border-top-right-radius: 10px;border:none;padding: 10px;border-left:  1px solid #5045E5; ">P</button>
                    </div>
                    <ul style="display: flex; list-style: none; align-items: center;gap: 10px;border-bottom: 1px solid #374151;justify-content: center;margin: 0px;padding: 5px 0;">
                        <li>
                            <svg xmlns="http://www.w3.org/2000/svg" width="40px" height="40px" viewBox="0 0 24 24">
                            <path fill="#f6f6f6" d="M3 19V5h18v14zm1-1h16V6H4zm0 0V6z" />
                            </svg>
                        </li>
                        <li>
                            <svg xmlns="http://www.w3.org/2000/svg" width="35px" height="35px" viewBox="0 0 24 24">
                            <path fill="#f6f6f6" d="M1 21L11.5 2.81L22 21zm19.27-1L11.5 4.81L2.73 20z" />
                            </svg>
                        </li>
                        <li>
                            <svg xmlns="http://www.w3.org/2000/svg" width="36px" height="36px" viewBox="0 0 24 24">
                            <path fill="#f6f6f6" d="M12.003 21q-1.866 0-3.51-.708q-1.643-.709-2.859-1.924t-1.925-2.856T3 12.003t.709-3.51Q4.417 6.85 5.63 5.634t2.857-1.925T11.997 3t3.51.709q1.643.708 2.859 1.922t1.925 2.857t.709 3.509t-.708 3.51t-1.924 2.859t-2.856 1.925t-3.509.709M12 20q3.35 0 5.675-2.325T20 12t-2.325-5.675T12 4T6.325 6.325T4 12t2.325 5.675T12 20m0-8" />
                            </svg>
                        </li>
                    </ul>
                    <form class="inputForm" action="caculateServlet" method="post">
                        <input hidden id="shape" name="shape"/>
                        <input hidden id="cal" name="cal"/>
                        <div class="form" style="display: flex; flex-direction: column;gap:10px;padding: 20px;display: none;">
                            <label for="length">Length (a)</label>
                            <input id="length" name="length" type="number" />
                            <label for="width">Width (b)</label>
                            <input id="width" name="width" type="number" />
                        </div>

                        <div class="form" style="display: flex; flex-direction: column;gap:10px;padding: 20px;display: none;">
                            <label for="edgeA">Edge (a)</label>
                            <input id="edgeA" name="edgeA" type="number" />
                            <label for="edgeB">Edge (b)</label>
                            <input id="edgeB" name="edgeB" type="number" />
                            <label for="edgeC">Edge (c)</label>
                            <input id="edgeC" name="edgeC" type="number" />
                        </div>

                        <div class="form" style="display: flex; flex-direction: column;gap:10px;padding: 20px;display: none;">
                            <label for="radius">Radius (r)</label>
                            <input id="radius" name="radius" type="number" />
                        </div>

                        <div style="display: flex; justify-content: center;background-color: #374151; padding: 10px 0; border-bottom-right-radius: 10px;border-bottom-left-radius: 10px;">
                            <button type="submit" style="width: fit-content;background-color: #5045E5;border: none;padding: 10px 18px;border-radius: 5px;color: #fff;font-size: 16px;cursor: pointer;">Calculate</button>
                        </div>
                    </form>
                </div>
                <div style="background-color: #1C3782;width: 350px;border-radius: 10px;display: flex;align-items: center; padding: 20px;gap:5px;">
                    <label>Result: </label>
                    <input id="result" style="background-color: transparent;border: none;border-bottom: 1px solid #5045E5;width: 100%;color: #fff;font-size: 16px;" readonly  value="<%= (result != null) ? result : "" %>"/>
                </div>
            </div>
        </section>
        <script>
            const listItems = document.querySelectorAll('ul li');
            const inputForms = document.querySelectorAll('.inputForm > .form');
            listItems.forEach((item, index) => {
                item.addEventListener('click', () => {
                    listItems.forEach((li) => li.classList.remove('active'));
                    inputForms.forEach((form) => (form.style.display = 'none'));
                    item.classList.add('active');
                    inputForms[index].style.display = 'flex';
                    switch (index) {
                        case 0:
                            document.querySelector("#shape").value = 'rectangle';
                            break;
                        case 1:
                            document.querySelector("#shape").value = 'triangle';
                            break;
                        case 2:
                            document.querySelector("#shape").value = 'circle';
                            break;
                        default:
                            document.querySelector("#shape").value = '';
                    }
                });
            });
            const calButtons = document.querySelectorAll('.cal button');
            calButtons.forEach((item, index) => {
                item.addEventListener('click', () => {
                    calButtons.forEach((i) => i.classList.remove('active'));
                    item.classList.add('active');
                    if (index === 0) {
                        document.querySelector("#cal").value = "S";
                    }
                    if (index === 1) {
                        document.querySelector("#cal").value = "P";
                    }
                });
            });
        </script>
    </body>
</html>
