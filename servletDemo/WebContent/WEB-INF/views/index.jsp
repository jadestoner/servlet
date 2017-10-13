<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>
<body>
<%@ include file="layout/navigation.jsp"%>
<%@ include file="moudles/photoWall.jsp"%>

<%@ include file="moudles/interact.jsp"%>
<%@ include file="moudles/blog.jsp"%>
<%@ include file="moudles/hope.jsp"%>

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
