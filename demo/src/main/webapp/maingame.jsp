<%@ page import="Database.DatabaseConn" %>
<%@ page import="com.example.demo.QuestionDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.Question" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01/12/2023
  Time: 2:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"> -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <title>MainGame</title>
</head>
<style>
    *{
        margin: 0px;
        padding: 0px;
    }
    body{
        background-image: url('${pageContext.request.contextPath}\\img\\bg2.png');
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        margin: 0;
        padding: 0;
        height: 100vh;
        overflow: hidden;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }
    section
    {
        /* padding: 0 100px; */
        /*background: url("");*/
        height: 100vh;
        display: flex;
        justify-content: center;
        background-repeat: no-repeat;
        background-size: cover;
        background-position: center;
    }
    img {
        width: 500px;
        height: 250px;
        text-align: center;
        position: absolute;
        top: 5%;
        left: 36%;
    }
    .question {
        width: 1200px;
        height: 150px;
        font-size: x-small;
        text-align: left;
        background-color: rgb(255, 255, 255);
        padding: 20px;
        border-radius: 20px ;
        position: absolute;
        top: 44%;
        left: 10%;
    }

    .back {
        position: absolute;
        top: 7%;
        left: 4%;
        transform: translate(-50%, -50%);
        font-size: 70px;
    }
    .answer2 {
        width: 900px;
        height: 200px;
        position: absolute;
        top: 62%;
        left: 11%;
    }
    .items {
        display: grid;
        grid-template-columns: 500px 500px;
    }
    .item {
        background-color: rgb(255, 255, 255);
        height: 80px;
        margin: 10px;
        border: 1px solid rgb(0, 0, 0);
        border-radius:  20px;
        padding: 20px;
        font-size: 25px;
    }

    .item:hover {
        background-color: #ffd700; /* Yellow color */
        /* Add other styles as needed */
        cursor: pointer; /* Change cursor to pointer on hover */
    }
</style>
<body>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<section>
    <div class="container">
        <i class="fa-solid fa-circle-chevron-left back" style="color: #ffffff;"></i>
        <%
           ;


            List<Question> q = (List<Question>) request.getAttribute("questions");
            Object number = request.getSession().getAttribute("number");
            int i = number == null ? 0 : (int) number;
            if(i>q.size()){
                i = q.size();
            }
            Question question1 = q.get(i);


            Object s = request.getSession().getAttribute("score");
            if(s == null){
                s = 0;
            }
            int score = (int) s;



        %>
        <img src="${pageContext.request.contextPath}\img\<%=question1.getImage()%>" alt="">
        <div class="stt"><%=question1.getId()%></div>
        <div class="question" style="font-size: 25px;"><h2><%=question1.getIdQuestions()%></h2></div>
    </div>

    <div class="answer2">
        <div class="score" id="diem"><%=score%></div>
        <div class="items">
            <div class="item"> A: <%=question1.getAnswerA()%>
            </div>
            <div class="item"> B: <%=question1.getAnswerB()%>
            </div>
            <div class="item"> C: <%=question1.getAnswerC()%>
            </div>
            <div class="item"> D: <%=question1.getAnswerD()%>
            </div>
        </div>
    </div>

</section>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
    $(document).ready(function () {
        $('.item').click(function () {
            var selectedAnswer = $(this).text().trim();
            var id = $('.stt').text().trim();
            var score = $('.score').text().trim();
            // Gửi request AJAX
            $.ajax({
                type: 'POST',
                url: '/demo_war_exploded/answer',
                data: { selectedAnswer: selectedAnswer,
                        id: id,
                        score : score
                    },
                success: function (response) {


                    var data = JSON.parse(response);
                    const x = data.value;

                    if(data.flag==true){

                        location.reload();

                    }else {

                        location.reload();


                    }



                },
                error: function (error) {

                    console.error(error);
                }
            });
        });
    });

</script>
</body>
</html>
