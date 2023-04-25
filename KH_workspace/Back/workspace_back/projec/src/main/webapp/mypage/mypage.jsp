<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Mypage</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
crossorigin="anonymous"></script>
	<style>
	
			*{box-sizing:border-box;}
			
            button {
                border-radius: 15px;
                border: none;
                background-color: black;
                color: white;
                font-size: 12px;
                height: 30px;
            }
    
            .mypage {
                width: 1114px;
                height: 1000px;
                margin: auto;
                margin-top: 20px;
            }
    
            .header {
                height: 5%;
                text-align: center;
                line-height: 49px;
                font-size: 15px;
                font-weight: bold;
                background-color: rgb(245, 245, 245);
                border-bottom: 1px solid black;
                border-top: 1px solid black;
            }
    
            .body1 {
                height: 50%;
            }
    
            .body2 {
                height: 45%;
            }
    
            .body1>div {
                float: left;
                height: 100%;
            }
    
            .profile {
                width: 35%;
            }
    
            .inpomation {
                width: 65%;
            }
    
            .inpomation>div {
                float: left;
                height: 100%;
            }
    
            .inpocontents1 {
                width: 20%;
            }
    
            .inpocontents1>ul {
                list-style: none;
                margin-top: 50px;
                padding: 0px;
                padding-left: 40px;
            }
    
            .inpocontents1>ul>li {
                margin-bottom: 24px;
                font-size: 14px;
            }
    
            .inpocontents2 {
                width: 80%;
                padding-top: 45px;
                padding-left: 20px;
                position: relative;
            }
    
            .inpocontents2>input {
                margin-bottom: 15px;
                width: 300px;
            }
    
            .inpocontents2>button {
                position: absolute;
                left: 125px;
                width: 75px;
                top:460px;
            }
    
            .profileImage {
                height: 65%;
            }
    
            .proImage {
                width: 250px;
                height: 250px;
                border-radius: 200px;
                position: relative;
                left: 63px;
                top: 45px;
                border: 1px solid black;
            }
    
            .profileName {
                height: 35%;
                text-align: center;
            }
    
            .profileName>button {
                font-size: 12px;
                width: 75px;
                position: relative;
                right: 8px;
            }
    
            button:hover {
                opacity: 70%;
            }
    
            #postSearch {
                position: relative;
                left: 15px;
                top: 0px;
                display: none;
            }
            #modiComBtn{
                display:none;
            }
            .body2 {
                padding: 30px;
            }
            .body2Navi {
                height: 10%;
            }
    
            .body2Navi>a{
                height:100%;
                background-color:white;
                border:1px solid black;
                color:black;
                position: relative;
                top:10px;
                font-size: 12px;
                height:30px;
                display:inline-block;
                width:80px;
                text-align:center;
                line-height:30px;
                text-decoration:none;
            }
            .body2Navi>a:first-of-type{
                border-bottom:none;
            }
            .body2Contents {
                width:100%;
                height: 80%;
                border: 1px solid black;
            }  
        </style>
    </head>
    <body>
        <div class="mypage">
            <div class="header">����������</div>
            <div class="body1">
                <div class="profile">
                    <div class="profileImage">
                        <div class="proImage"></div>
                    </div>
                    <div class="profileName"><button>�����ϱ�</button></div>
                </div>
                <div class="inpomation">
                    <div class="inpocontents1">
                        <ul>
                            <li>���̵�</li>
                            <li>�̸�</li>
                            <li>�г���</li>
                            <li>�ڵ�����ȣ</li>
                            <li>email</li>
                            <li>Ŭ������</li>
                            <li>�����ȣ</li>
                            <li>�ּ�1</li>
                            <li>�ּ�2</li>
                        </ul>
                    </div>
                    <div class="inpocontents2">
                        <input type="text"><br>
                        <input type="text"><br>
                        <input type="text"><br>
                        <input type="text"><br>
                        <input type="text"><br>
                        <input type="text"><br>
                        <input type="text"><button id="postSearch">�ּ�ã��</button><br>
                        <input type="text"><br>
                        <input type="text"><br>
                        <button id="modiBtn">�����ϱ�</button>
                        <button id="modiComBtn">�����Ϸ�</button>
                    </div>
                </div>
            </div>
            <div class="body2">
                <div class="body2Navi">
                    <a href="#" class="myContents">���� �� ��</a>
                    <a href="#" class="myContents">���� �� ���</a>
                </div>
                <div class="body2Contents"></div>
            </div>
        </div>
        <script>
            $("document").ready(function(){
                $("#modiBtn").on("click", function(){
                    $("#postSearch").css("display", "inline-block");
                    $("#modiBtn").css("display","none");
                    $("#modiComBtn").css("display","inline-block");
                })

                $("#modiComBtn").on("click",function(){
                    $("#modiComBtn").css("display","none");
                    $("#modiBtn").css("display","inline-block");
                    $("#postSearch").css("display", "none");
                })

                $(".myContents").on("click",function(){
                    $(this).css("border-bottom","none");
                    $(".myContents").not(this).css("border-bottom","1px solid black");
            })
            })
        </script>
</body>
</html>