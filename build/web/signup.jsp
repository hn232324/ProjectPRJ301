<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">


<div class="container" >
<hr>





<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Create Account</h4>
        <p class="text-danger" >${sessionScope.mess}</p>
	<p class="divider-text">
    </p>
   <div style="color: red">${requestScope.mess}</div>
    <form action="signup" method="post">
	
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="user" type="text" id="user-name" class="form-control" placeholder="Username" required="" autofocus="">
    </div> <!-- form-group// -->
    
  
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input name="pass" type="password" id="user-pass" class="form-control" placeholder="Password" required autofocus="">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input name="repass" type="password" id="user-repeatpass" class="form-control" placeholder="Repeat Password" required autofocus="">
    </div> <!-- form-group// -->              
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input name="email" type="email" id="user-repeatpass" class="form-control" placeholder="Email" required autofocus="">
    </div> <!-- form-group// -->            
    <div class="form-group">
        <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Sign Up</button>
    </div> <!-- form-group// -->      
    <p class="text-center">Have an account? <a href="login.jsp">Log In</a> </p>                                                                 
</form>
</article>
</div> <!-- card.// -->

</div> 
<!--container end.//-->

<br><br>