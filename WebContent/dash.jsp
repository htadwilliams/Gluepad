<html>
   <head><title>Home dashboard</title></head>
   <body>
	<h2> Gluepad Dashboard </h2>
	<!-- The hack to add a link to the div supposedly works in FF and SF, but not IE7/8 -->
    <div style="position: relative">
	<iframe src="http://192.168.1.111/video3.mjpg" width="100%" height="176" style="border:none; "></iframe>
	<a href="http://192.168.1.111/video2.mjpg" style="position: absolute; top: 0; right: 0; bottom: 0; left: 0;"></a>
	</div>
	   <h3> Mouse Control </h3>
		<form action="${pageContext.request.contextPath}/Gluepad" method="post">
			<button type="submit" name="button" value="button_mouse_hold">Hold LB</button>
			<button type="submit" name="button" value="button_mouse_release">Release LB</button>
			<p>
			<button type="submit" name="button" value="button_mouse_lock">Lock</button>
			<button type="submit" name="button" value="button_mouse_unlock">Unlock</button>
		</form>      
	</body>
</html>
