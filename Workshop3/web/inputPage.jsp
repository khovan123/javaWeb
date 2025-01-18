<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            <form class="form" action="${student!=null&&_id!=null?"../student/update":"../student/create"}" method="post">
                <c:if test="${student!=null&&_id!=null}">
                    <input type="hidden" value="${_id}" id="_id" name="_id"/>
                </c:if>
                <h1>Resgister Now</h1>
                <div>
                    <label>ID</label>
                    <input id="id" name="id" type="number" required value="${student!=null?student.getId():""}"/>
                    <c:if test="${error != null}">
                        <p style="color: red;font-size: 12px;">${error}</p>
                    </c:if>

                </div>
                <div>
                    <label>Name</label>
                    <input id="name" name="name" type="text" required value="${student!=null?student.getName():""}"/>
                </div>
                <div class="selectContainer">
                    <label>Gender</label>
                    <div>
                        <span>Male</span>
                        <input type="radio" name="gender" id="male" value="male" required ${student!=null&&student.isGender()?"checked":""}/>
                    </div>
                    <div>
                        <span>Female</span>
                        <input type="radio" name="gender" id="female" value="female" required ${student!=null&&student.isGender()==false?"checked":""}/>
                    </div>
                </div>
                <div>
                    <label>DoB</label>
                    <input type="date" name="dob" id="dob" required value="${student!=null?student.getDob():""}"/>
                </div>
                <div class="buttonContainer">
                    <c:if test="${student!=null&&_id!=null}">
                        <button>Update</button>
                    </c:if>
                    <c:if test="${student==null||_id==null}">
                        <button>Create</button>
                    </c:if>
                </div>

            </form>
        </div>
    </body>
</html>
