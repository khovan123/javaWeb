<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        text-transform: uppercase;
                        color: #7048e8;
                        font-weight: 700;
                        font-family: fantasy;
                        font-size: 64px;
                    }

                    .selectContainer{
                        display: flex;
                        flex-direction: row;

                        select{
                            border-radius: 5px;
                            padding: 4px;
                            border: 1px solid #ced4da;
                        }

                        select:focus{
                            outline: none;
                        }

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
                        transform: scale(1.1);
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
            <form class="form" action="CalServlet" method="post">
                <h1>Caculator</h1>
                <div>
                    <label>First Number</label>
                    <input id="first" name="first" type="number" value="${first!=null?first:""}" required/>
                </div>            
                <div class="selectContainer">
                    <label for="operator">Operator</label>
                    <select id="operator" name="operator" required>
                        <option value="+" ${operator!=null&&operator.equals("+")?"selected":""}>+</option>
                        <option value="-" ${operator!=null&&operator.equals("-")?"selected":""}>-</option>
                        <option value="*" ${operator!=null&&operator.equals("*")?"selected":""}>*</option>
                        <option value="/" ${operator!=null&&operator.equals("/")?"selected":""}>/</option>
                    </select>
                </div> 
                <div>
                    <label>Second Number</label>
                    <input id="second" name="second" type="number" value="${second!=null?second:""}" required/>
                </div>
                <div class="buttonContainer">
                    <button>Caculate</button>
                </div>
                <c:if test="${result!=null}">
                    <div>
                        <label>Result</label>
                        <c:if test="${result.getClass().name == 'java.lang.String'}">
                            <input id="result" name="result" type="text" value="${result}" readonly disabled style="color: gray;"/>
                        </c:if>
                        <c:if test="${result.getClass().name == 'java.lang.Integer'||result.getClass().name == 'java.lang.Double'}">
                            <input id="result" name="result" type="text" value="${result}" readonly/>
                        </c:if>
                    </div>
                </c:if>
            </form>
        </div>
    </body>
</html>
