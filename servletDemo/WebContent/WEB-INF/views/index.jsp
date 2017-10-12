<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>二叉树的最优解法</title>
<meta name="Keywords" content="" >
<meta name="Description" content="" >
<link href="css/index.css" rel="stylesheet">
<script src="js/external/jquery-3.2.1.js"></script>
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
</head>
<body>
<div class="topnav">
<div id="nav">
    <ul>
      <li><a id="top" href="#top" >首页</a></li>
      <li><a id="top_photowall" href="javascript:void(0);">我們的照片</a></li>
      <li><a id="top_about" href="javascript:void(0);">我們的互动</a></li>
      <li><a id="top_blog" href="javascript:void(0);">我們的博客</a></li>
      <li><a id="top_my_hope" href="javascript:void(0);">遊客的留言</a></li>
    </ul>
  </div>
</div>
<header>
  <div class="quotes">
    <p>初遇时，她的微笑，她往日的深情、承诺和傻劲，两个人共度的美丽时刻，一一印在回忆里，今天的感情已经比不上从前，但是我爱着恋着往日的她，舍不得离开。</p>
<!--     <div class="text5">记录・回忆</div> -->
    <div class="flower"><img src="images/flower.jpg"></div>
  </div>

</header>
<div class="rotate photowall" style="display: none">
  <ul class="wall_a">
    <li><a href="/"><img src="images/p01.jpg">
      <figcaption>
        <h2>不再因为别人过得好而焦虑，在没有人看得到你的时候依旧能保持节奏 </h2>
      </figcaption>
      </a></li>
    <li><a href="/"><img src="images/p02.jpg">
      <figcaption>
        <h2>不再因为别人过得好而焦虑，在没有人看得到你的时候依旧能保持节奏 </h2>
      </figcaption>
      </a></li>
    <li><a href="/"><img src="images/p03.jpg">
      <figcaption>
        <h2>不再因为别人过得好而焦虑，在没有人看得到你的时候依旧能保持节奏 </h2>
      </figcaption>
      </a></li>
    <li>
      <p class="text_a"><a href="/">一个人最好的模样大概是平静一点，坦然接受自己所有的弱点，不再因为别人过得好而焦虑，在没有人看得到你的时候依旧能保持节奏......</a></p>
    </li>
    <li><a href="/"><img src="images/p04.jpg">
      <figcaption>
        <h2>不再因为别人过得好而焦虑，在没有人看得到你的时候依旧能保持节奏 </h2>
      </figcaption>
      </a></li>
    <li>
      <p class="text_b"><a href="/">逃避自己的人，最终只能导致自己世界的崩塌，而变得越来越没有安全感。</a></p>
    </li>
    <li><a href="/"><img src="images/p05.jpg">
      <figcaption>
        <h2>不再因为别人过得好而焦虑，在没有人看得到你的时候依旧能保持节奏 </h2>
      </figcaption>
      </a></li>
  </ul>
</div>

<div class="rotate about" style="display: none">
  <ul>
    <div id="fountainG">
      <li></li>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
    </div>
    <div class="about_girl"><span><a href="/"><img src="images/girl.jpg"></a></span>
      <p>
  <%=new Date()%><br/>初遇时，他的幽默，他往日的深情、承诺和傻劲儿，两个人共度的美丽时刻，一一印在我的回忆里....</p>
    </div>
    <div class="about_boy"><span><a href="/"><img src="images/boy.jpg"></a></span>
      <p><%=new Date() %><br/>初遇时，她的热情，她腼腆的微笑、可爱和气质，两个人共度的愉快时刻，一一印在我的回忆里...</p>
    </div>
   	<div>
   		<p>
       		 <input type="text" placeholder="type and press enter to chat" id="chat" />
    	</p>
    	 <div id="console-container">
        	<div id="console"/>
    </div>
   	</div>
  </ul>
</div>

<div class="rotate blog" style="display: none">
  <figure> <a href="/"><img src="images/t01.jpg"></a>
    <p><a href="/">愿有人陪你一起颠沛流离</a></p>
    <figcaption>有一天晚上我收到朋友的邮件，他问我怎样可以最快地摆脱寂寞，我想了想不知道应该怎么回答他，因为我从来没有摆脱过这个问题，我只能去习惯它，就像习惯身体的一部分。</figcaption>
  </figure>
  <figure> <a href="/"><img src="images/t02.jpg"></a>
    <p><a href="/">你要去相信，没有到不了的明天</a></p>
    <figcaption>不管你现在是一个人走在异乡的街道上始终没有找到一丝归属感，还是你在跟朋友们一起吃饭开心地笑着的时候闪过一丝落寞。</figcaption>
  </figure>
  <figure> <a href="/"><img src="images/t03.jpg"></a>
    <p><a href="/">美丽的茧</a></p>
    <figcaption>让世界拥有它的脚步，让我保有我的茧。当溃烂已极的心灵再不想做一丝一毫的思索时，就让我静静回到我的茧内，以回忆为睡榻，以悲哀为覆被，这是我唯一的美丽。</figcaption>
  </figure>
</div>

<div class="rotate my_hope" style="display: none">
<!-- 	<div class="text6">相守・祝福</div> -->
	<div class="hope" name="#hope">
	  <ul>
	    <div class="visitors">
	      <dl>
	        <dt><img src="images/s6.jpg"> </dt>
	        <dd><a href="/">DanceSmile</a> </dd>
	        <dd>你们本就是天生一对，地造一双，而今共偕连理，今后更需彼此宽容、互相照顾，祝福你们！</dd>
	      </dl>
	      <dl>
	        <dt><img src="images/s7.jpg"> </dt>
	        <dd><a href="/">骄傲的小甜甜</a> </dd>
	        <dd>十年修得同船渡，百年修得共枕眠。于茫茫人海中找到她，分明是千年前的一段缘，祝你俩幸福美满，共谐连理。</dd>
	      </dl>
	      <dl>
	        <dt><img src="images/s8.jpg"> </dt>
	        <dd><a href="/">执子之手</a> </dd>
	        <dd>托清风捎去衷心的祝福，让流云奉上真挚的情意；今夕何夕，空气里都充满了醉人的甜蜜。谨祝我最亲爱的朋友，从今后，爱河永浴！</dd>
	      </dl>
	      <dl>
	        <dt><img src="images/s7.jpg"> </dt>
	        <dd><a href="/">骄傲的小甜甜</a> </dd>
	        <dd>十年修得同船渡，百年修得共枕眠。于茫茫人海中找到她，分明是千年前的一段缘，祝你俩幸福美满，共谐连理。</dd>
	      </dl>
	      <dl>
	        <dt><img src="images/s8.jpg"> </dt>
	        <dd><a href="/">执子之手</a> </dd>
	        <dd>托清风捎去衷心的祝福，让流云奉上真挚的情意；今夕何夕，空气里都充满了醉人的甜蜜。谨祝我最亲爱的朋友，从今后，爱河永浴！</dd>
	      </dl>
	      <dl>
	        <dt><img src="images/s7.jpg"> </dt>
	        <dd><a href="/">骄傲的小甜甜</a> </dd>
	        <dd>十年修得同船渡，百年修得共枕眠。于茫茫人海中找到她，分明是千年前的一段缘，祝你俩幸福美满，共谐连理。</dd>
	      </dl>
	      <dl>
	        <dt><img src="images/s8.jpg"> </dt>
	        <dd><a href="/">执子之手</a> </dd>
	        <dd>托清风捎去衷心的祝福，让流云奉上真挚的情意；今夕何夕，空气里都充满了醉人的甜蜜。谨祝我最亲爱的朋友，从今后，爱河永浴！</dd>
	      </dl>
	      <dl>
	        <dt><img src="images/s7.jpg"> </dt>
	        <dd><a href="/">骄傲的小甜甜</a> </dd>
	        <dd>十年修得同船渡，百年修得共枕眠。于茫茫人海中找到她，分明是千年前的一段缘，祝你俩幸福美满，共谐连理。</dd>
	      </dl>
	      <dl>
	        <dt><img src="images/s8.jpg"> </dt>
	        <dd><a href="/">执子之手</a> </dd>
	        <dd>托清风捎去衷心的祝福，让流云奉上真挚的情意；今夕何夕，空气里都充满了醉人的甜蜜。谨祝我最亲爱的朋友，从今后，爱河永浴！</dd>
	      </dl>
	    </div>
	  </ul>
	</div>
</div>
<!-- <footer> -->
<!--   <p>Design by <a href="" target="_blank">po_shi</a></p> -->
<!-- </footer> -->
</body>
</html>
<script type="text/javascript">
$(function(){
	$("#top").click(function(){
		 $(".rotate").hide();
	});
	$("#nav ul #top_photowall").click(function(){
		 $(".rotate").hide();
		$(".photowall").toggle();
	});
	$("#nav ul #top_about").click(function(){
		 $(".rotate").hide();
		$(".about").toggle();
	});
	$("#nav ul #top_blog").click(function(){
		 $(".rotate").hide();
		$(".blog").toggle();
	});
	$("#nav ul #top_my_hope").click(function(){
		 $(".rotate").hide();
		$(".my_hope").toggle();
	});
});
</script>
 <script type="application/javascript">

        var Chat = {};

        Chat.socket = null;

        Chat.connect = (function(host) {
            if ('WebSocket' in window) {
                Chat.socket = new WebSocket(host);
            } else if ('MozWebSocket' in window) {
                Chat.socket = new MozWebSocket(host);
            } else {
                Console.log('Error: WebSocket is not supported by this browser.');
                return;
            }

            Chat.socket.onopen = function () {
                Console.log('Info: WebSocket connection opened.');
                document.getElementById('chat').onkeydown = function(event) {
                    if (event.keyCode == 13) {
                        Chat.sendMessage();
                    }
                };
            };

            Chat.socket.onclose = function () {
                document.getElementById('chat').onkeydown = null;
                Console.log('Info: WebSocket closed.');
            };

            Chat.socket.onmessage = function (message) {
                Console.log(message.data);
            };
        });

        Chat.initialize = function() {
            if (window.location.protocol == 'http:') {
            	
                Chat.connect('ws://'+window.location.host+'/servletDemo/websocket/chat');
            } else {
                Chat.connect('wss://'+window.location.host+'/servletDemo/websocket/chat');
            }
        };

        Chat.sendMessage = (function() {
            var message = document.getElementById('chat').value;
            if (message != '') {
                Chat.socket.send(message);
                document.getElementById('chat').value = '';
            }
        });

        var Console = {};

        Console.log = (function(message) {
            var console = document.getElementById('console');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.innerHTML = message;
            console.appendChild(p);
            while (console.childNodes.length > 25) {
                console.removeChild(console.firstChild);
            }
            console.scrollTop = console.scrollHeight;
        });

        Chat.initialize();


        document.addEventListener("DOMContentLoaded", function() {
            // Remove elements with "noscript" class - <noscript> is not allowed in XHTML
            var noscripts = document.getElementsByClassName("noscript");
            for (var i = 0; i < noscripts.length; i++) {
                noscripts[i].parentNode.removeChild(noscripts[i]);
            }
        }, false);
</script>
