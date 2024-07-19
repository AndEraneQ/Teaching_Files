<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../css/bootstrap/bootstrap.css">
  <link rel="stylesheet" href="../css/main.css">
  <script src="https://kit.fontawesome.com/44dbd555de.js" crossorigin="anonymous"></script>
  <title>Dashboard</title>
</head>

<body>
    <!-- Header -->
  <c:import url = "components/incl/header.jsp"/>

<!-- Container -->
    <div class="container">

       <!-- Card: Payment History Card -->
       <div class="card">
            <!-- Card Header -->
            <div class="card-header">
                <i class="fas fa-credit-card me-2" aria-hidden="true"></i> Payment History
            </div>
            <!-- End Of Card Header -->
            <!-- Card Body -->
            <div class="card-body">
            <c:if test="${requestScope.payment_history != null}">
                <!-- Payment History Table -->
                <table class="table text-center table-striped">
                    <tr>
                        <th>Record Number</th>
                        <th>Beneficiary</th>
                        <th>Beneficiary Account Number</th>
                        <th>Amount</th>
                        <th>Status</th>
                        <th>Reference</th>
                        <th>Reason Code</th>
                        <th>Created at</th>
                    </tr>
                    <!-- Loop Through Payment History Records -->
                    <c:forEach items="${requestScope.payment_history}" var="payments">
                    <tr>
                        <td>${payments.payment_id}</td>
                        <td>${payments.beneficiary}</td>
                        <td>${payments.beneficiary_account_number}</td>
                        <td>${payments.amount}</td>
                        <td>${payments.status_}</td>
                        <td>${payments.reference_no}</td>
                        <td>${payments.reason_code}</td>
                        <td>${payments.created_at}</td>
                    </tr>
                     </c:forEach>
                    <!-- End Of Loop Through Payment History Records -->

                </table>
                <!-- End Of Payment History Table -->
            </c:if>
            </div>
            <!-- End Of Card Body -->
       </div>
       <!-- End Of Card: Payment History Card -->
    </div>
    <!-- End Of Container -->




  <!-- Footer -->
    <c:import url = "components/incl/footer.jsp"/>