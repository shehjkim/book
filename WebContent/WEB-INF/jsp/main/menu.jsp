<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>메뉴</title>
</head>
<style>
body {
  background: #fff;
  color: #444;
  font-family: "Open Sans", sans-serif;
}

a {
  color: #1bb1dc;
  text-decoration: none;
  transition: 0.5s;
}

a:hover, a:active, a:focus {
  color: #0a98c0;
  outline: none;
  text-decoration: none;
}

p {
  padding: 0;
  margin: 0 0 30px 0;
}

h1, h2, h3, h4, h5, h6 {
  font-family: "Montserrat", sans-serif;
  font-weight: 400;
  margin: 0 0 20px 0;
  padding: 0;
}

@media (prefers-reduced-motion: no-preference) {
  :root {
    scroll-behavior: auto;
  }
}

/*--------------------------------------------------------------
# Header
--------------------------------------------------------------*/
#header {
  background: #fff;
  transition: all 0.5s;
  z-index: 997;
  padding: 15px 0;
  top: 40px;
}

#header.header-transparent {
  background: transparent;
}

#header.header-scrolled {
  top: 0;
  background: #fff;
  box-shadow: 0px 0px 30px rgba(127, 137, 161, 0.3);
}

#header .logo {
  font-size: 36px;
  margin: 0;
  padding: 0;
  line-height: 1;
  font-weight: 400;
  letter-spacing: 3px;
  text-transform: uppercase;
}

#header .logo a {
  color: #413e66;
}

#header .logo img {
  max-height: 40px;
}

@media (max-width: 992px) {
  #header {
    top: 0;
  }
  #header .logo {
    font-size: 28px;
  }
}

/*--------------------------------------------------------------
# Navigation Menu
--------------------------------------------------------------*/
/* Desktop Navigation */
.main-nav {
  /* Drop Down */
  /* Deep Drop Down */
}

.main-nav, .main-nav * {
  margin: 0;
  padding: 0;
  list-style: none;
}

.main-nav > ul > li {
  position: relative;
  white-space: nowrap;
  float: left;
  padding-left: 30px;
}

.main-nav a {
  display: block;
  position: relative;
  color: #413e66;
  padding: 10px 0;
  transition: 0.3s;
  font-size: 14px;
  font-family: "Open Sans", sans-serif;
  text-transform: uppercase;
  font-weight: 600;
}

.main-nav a:hover, .main-nav .active > a, .main-nav li:hover > a {
  color: #1bb1dc;
  text-decoration: none;
}

.main-nav .drop-down ul {
  display: block;
  position: absolute;
  left: 15px;
  top: calc(100% + 30px);
  z-index: 99;
  opacity: 0;
  visibility: hidden;
  padding: 10px 0;
  background: #fff;
  box-shadow: 0px 0px 30px rgba(127, 137, 161, 0.25);
  transition: ease all 0.3s;
}

.main-nav .drop-down:hover > ul {
  opacity: 1;
  top: 100%;
  visibility: visible;
}

.main-nav .drop-down li {
  min-width: 180px;
  position: relative;
}

.main-nav .drop-down ul a {
  padding: 10px 20px;
  font-size: 14px;
  font-weight: 500;
  text-transform: none;
  color: #065e77;
}

.main-nav .drop-down ul a:hover, .main-nav .drop-down ul .active > a, .main-nav .drop-down ul li:hover > a {
  color: #1bb1dc;
}

.main-nav .drop-down > a:after {
  content: "\f107";
  font-family: FontAwesome;
  padding-left: 10px;
}

.main-nav .drop-down .drop-down ul {
  top: 0;
  left: calc(100% - 30px);
}

.main-nav .drop-down .drop-down:hover > ul {
  opacity: 1;
  top: 0;
  left: 100%;
}

.main-nav .drop-down .drop-down > a {
  padding-right: 35px;
}

.main-nav .drop-down .drop-down > a:after {
  content: "\f105";
  position: absolute;
  right: 15px;
}

/* Mobile Navigation */
.mobile-nav {
  position: fixed;
  top: 0;
  bottom: 0;
  z-index: 9999;
  overflow-y: auto;
  left: -260px;
  width: 260px;
  padding-top: 18px;
  background: rgba(40, 38, 70, 0.8);
  transition: 0.4s;
}

.mobile-nav * {
  margin: 0;
  padding: 0;
  list-style: none;
}

.mobile-nav a {
  display: block;
  position: relative;
  color: #fff;
  padding: 10px 20px;
  font-weight: 500;
}

.mobile-nav a:hover, .mobile-nav .active > a, .mobile-nav li:hover > a {
  color: #8dc2fa;
  text-decoration: none;
}

.mobile-nav .drop-down > a:after {
  content: "\f078";
  font-family: FontAwesome;
  padding-left: 10px;
  position: absolute;
  right: 15px;
}

.mobile-nav .active.drop-down > a:after {
  content: "\f077";
}

.mobile-nav .drop-down > a {
  padding-right: 35px;
}

.mobile-nav .drop-down ul {
  display: none;
  overflow: hidden;
}

.mobile-nav .drop-down li {
  padding-left: 20px;
}

.mobile-nav-toggle {
  position: fixed;
  right: 0;
  top: 0;
  z-index: 9998;
  border: 0;
  background: none;
  font-size: 24px;
  transition: all 0.4s;
  outline: none !important;
  line-height: 1;
  cursor: pointer;
  text-align: right;
}

.mobile-nav-toggle i {
  margin: 18px 18px 0 0;
  color: #065e77;
}

.mobile-nav-overly {
  width: 100%;
  height: 100%;
  z-index: 9997;
  top: 0;
  left: 0;
  position: fixed;
  background: rgba(40, 38, 70, 0.8);
  overflow: hidden;
  display: none;
}

.mobile-nav-active {
  overflow: hidden;
}

.mobile-nav-active .mobile-nav {
  left: 0;
}

.mobile-nav-active .mobile-nav-toggle i {
  color: #fff;
}

</style>
<body>
  <header id="header" class="fixed-top header-transparent">
    <div class="container d-flex align-items-center justify-content-between"
    	 align="center">

      <h1 class="logo"><a href="index.html">Books</a></h1>
      <nav class="main-nav" align="center">
        <ul>
          <li class="active"><a href="main.do">Home</a></li>
          <li><a href="#">Book</a></li>
          <li><a href="#">MyPage</a></li>
          <li><a href="memberLoginForm.do">Login</a></li>
          <li><a href="memberLogout">Logout</a></li>
          <li class="drop-down"><a href="">Admin Only</a>
            <ul>
              <li><a href="memberList.do">회원 정보 관리</a></li>
              <li class="drop-down"><a href="#">도서 정보 관리</a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li>
              <li><a href="#">Drop Down 3</a></li>
              <li><a href="#">Drop Down 4</a></li>
              <li><a href="#">Drop Down 5</a></li>
            </ul>
          </li>
          <li><a href="#footer">Contact Us</a></li>
        </ul>
      </nav><!-- .main-nav-->
</div>
   
  </header><!-- End Header -->

  



</body>

</html>