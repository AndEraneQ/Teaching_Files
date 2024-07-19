<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!-- Main Page Header -->
  <header class="main-page-header mb-3 bg-primary">
    <!-- Container -->
    <div class="container d-flex align-items-center">
      <!-- Company Name -->
      <div class="company-name">
        Easy-way Bank
      </div>
      <!-- Company Name -->

      <!-- Navigation -->
      <nav class="navigation">
        <li><a href="/app/dashboard">Dashboard</a></li>
        <li><a href="/app/payment_history">Payment</a></li>
        <li><a href="/app/transact_history">Transaction History</a></li>
      </nav>
      <!-- End Of Navigation -->

      <!-- Display Name -->
      <div class="display-name ms-auto">
        <i class="fa fa-circle text-success me-2"></i> Welcome: <span>${user.first_name}  ${user.last_name}</span>
      </div>
      <!-- End Of Display Name -->

      <!-- Log out button -->
      <a href="/logout" class="btn btn-sm ms-2">
        <i class="fa fa-sign-out"></i> Sign out
      </a>
      <!-- End Of Log out button -->
    </div>
    <!-- End Of Container -->
  </header>
  <!-- Main Page Header -->