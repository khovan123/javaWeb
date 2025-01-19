<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Add New Student</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body{
                margin:0;
            }
            .container {
                width: 100vw;
                height: 100vh;
                display: flex;
                align-items: center;
                justify-content: center;

                .form{
                    box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
                    padding:40px 24px;
                    border-radius: 15px;
                    width: fit-content;
                    display: flex;
                    flex-direction: column;
                    gap:24px;

                    h1{
                        text-align: center;
                    }

                    .selectContainer{
                        display: flex;
                        flex-direction: row;

                        label{
                            flex-basis: 40%;
                        }

                        div{
                            display: flex;
                            align-items: center;
                            flex-basis: 30%;
                        }

                        span{
                            color:#495057;

                        }
                    }

                    .buttonContainer{
                        margin-left: auto;
                        margin-right: auto;
                    }

                    button{
                        margin-top: 12px;
                        width: fit-content;
                        background: #7048e8;
                        border: none;
                        color: white;
                        font-size: 16px;
                        padding: 12px 24px;
                        border-radius: 8px;
                        transition: all 0.25s linear;
                    }

                    button:hover{
                        transform: scale(1.2);
                    }

                }

                .form > div{
                    display: flex;
                    flex-direction: column;
                    gap: 14px;
                }

                .form > div> label{
                    color:#495057;
                }

                .form> div> input{
                    border-radius: 6px;
                    border: 1px solid #ced4da;
                    padding: 16px;
                    width: 350px;
                }

                .form>div>input:focus{
                    outline: none;
                    border: 1px solid #7048e8;
                }
            }
        </style>
    </head>
    <body>
        <div class="container">
            <form class="form" action="StudentServlet" method="post">
                <h1>Resgister Now</h1>
                <div>
                    <label>ID</label>
                    <input id="id" name="id" type="number" value="${student!=null?student.getId():""}" required/>
                    <c:if test="${student!=null}">
                        <p style="color: red;font-size: 12px;">Id was existed!</p>
                    </c:if>
                </div>
                <div>
                    <label>Name</label>
                    <input id="name" name="name" type="text" value="${student!=null?student.getName():""}" required/>
                </div>
                <div class="selectContainer">
                    <label>Gender</label>
                    <div>
                        <span>Male</span>
                        <input type="radio" name="gender" id="male" value="male" ${student!=null&&student.isGender()?"checked":""} required>
                    </div>
                    <div>
                        <span>Female</span>
                        <input type="radio" name="gender" id="female" value="female" ${student!=null&&!student.isGender()?"checked":""} required/>
                    </div>
                </div>
                <div>
                    <label>DoB</label>                    
                    <input type="date" name="dob" id="dob" value="<fmt:formatDate value='${student.getDob()}' pattern='yyyy-MM-dd'/>" required/>
                </div>
                <div class="buttonContainer">
                    <button>Create</button>
                </div>
            </form>
        </div>
    </body>
</html>
