<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Customer</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="css/home.css">

</head> 
<body>
   
  
        
<!-- header section starts  -->

<header class="header">

   <nav class="navbar nav-1">
      <section class="flex">
         <a href="home.html" class="logo"><i class="fas fa-house"></i>MyHome</a>

        
      </section>
   </nav>

   <nav class="navbar nav-2">
      <section class="flex">
         <div id="menu-btn" class="fas fa-bars"></div>

         <div class="menu">
            <ul>
               <li><a href="#">buy<i class="fas fa-angle-down"></i></a>
                  <ul>
                     <li><a href="#">house</a></li>
                     <li><a href="#">flat</a></li>
                     <li><a href="#">shop</a></li>
                   
                  </ul>
               </li>
               <li><a href="#">sell<i class="fas fa-angle-down"></i></a>
                  <ul>
                     <li><a href="#">post property</a></li>
                     <li><a href="#">dashboard</a></li>
                  </ul>
               </li>
               <li><a href="#">rent<i class="fas fa-angle-down"></i></a>
                  <ul>
                     <li><a href="#">house</a></li>
                     <li><a href="#">flat</a></li>
                     <li><a href="#">shop</a></li>
                  </ul>
               </li>
               <li><a href="#">help<i class="fas fa-angle-down"></i></a>
                  <ul>
                     <li><a href="about.html">about us</a></i></li>
                     <li><a href="contact.html">contact us</a></i></li>
                     <li><a href="contact.html#faq">FAQ</a></i></li>
                  </ul>
               </li>
            </ul>
         </div>

         <ul>
            <li><a href="#">saved <i class="far fa-heart"></i></a></li>
            <li><a href="#">account <i class="fas fa-angle-down"></i></a>
               <ul>
                  <li><a href="login.html">login</a></li>
                  <li><a href="register.html">register</a></li>
               </ul>
            </li>
         </ul> 
      </section>
   </nav>

</header>

<!-- header section ends -->

<!-- home section starts  -->

 


<section class="property-details-form">
   <div class="container">
      <h2>Provide Buyer Details</h2>
      <form action="InsertCustomerServlet" method="post">
      
      	<input type="hidden" name="command" value="ADD" />
      	
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required><br>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required><br>

        <label for="nicNumber">NIC Number:</label>
        <input type="text" id="nicNumber" name="nicNumber" required><br>

        <label for="message">Message:</label>
        <textarea id="message" name="message" rows="4" cols="50"></textarea><br>

        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
   </div>
</section>


<!-- home section ends -->

<!-- services section starts  -->











<!-- footer section starts  -->

<footer class="footer">

   <section class="flex">

      <div class="box">
         <a href="tel:1234567890"><i class="fas fa-phone"></i><span>123456789</span></a>
         <a href="tel:1112223333"><i class="fas fa-phone"></i><span>1112223333</span></a>
         <a href="mailto:shaikhanas@gmail.com"><i class="fas fa-envelope"></i><span>shaikhanas@gmail.com</span></a>
         <a href="#"><i class="fas fa-map-marker-alt"></i><span>mumbai, india - 400104</span></a>
      </div>

      <div class="box">
         <a href="home.html"><span>home</span></a>
         <a href="about.html"><span>about</span></a>
         <a href="contact.html"><span>contact</span></a>
         <a href="listings.html"><span>all listings</span></a>
         <a href="#"><span>saved properties</span></a>
      </div>

      <div class="box">
         <a href="#"><span>facebook</span><i class="fab fa-facebook-f"></i></a>
         <a href="#"><span>twitter</span><i class="fab fa-twitter"></i></a>
         <a href="#"><span>linkedin</span><i class="fab fa-linkedin"></i></a>
         <a href="#"><span>instagram</span><i class="fab fa-instagram"></i></a>

      </div>

   </section>

   <div class="credit">&copy; copyright @ 2022 by <span>mr. web designer</span> | all rights reserved!</div>

</footer>

<!-- footer section ends -->


<!-- custom js file link  -->
<script src="js/script.js"></script>

</body>
</html>