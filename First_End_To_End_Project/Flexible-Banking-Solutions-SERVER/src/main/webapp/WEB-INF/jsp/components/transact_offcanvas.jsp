<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!-- Start of Transact OffCanvas -->
  <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
    <div class="offcanvas-header">
      <h5 class="offcanvas-title text-white" id="offcanvasExampleLabel">Transact</h5>
      <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <!-- Offcanvas Transact Body -->
    <div class="offcanvas-body">
      <small class="card-text text-white">
        Choose an Option below to perform a transaction
      </small>
      <!-- Transaction type drop down list -->
      <select name="transact-type" class="form-control my-3" id="transact-type">
        <option value="">-- Select Transaction Type --</option>
        <option value="payment">Payment</option>
        <option value="transfer">Transfer</option>
        <option value="deposit">Deposit</option>
        <option value="withdraw">Withdraw</option>
      </select>
      <!-- End Of Transaction type drop down list -->

      <!-- Payments Form Card -->
      <c:import url ="components/transact_forms/payment_form.jsp"/>
      <!-- Transfer Form Card -->
      <c:import url ="components/transact_forms/transfer_form.jsp"/>
      <!-- Deposit Form Card -->
      <c:import url ="components/transact_forms/deposit_form.jsp"/>
      <!-- Withdraw Form Card -->
      <c:import url ="components/transact_forms/withdraw_form.jsp"/>








    </div>
    <!-- End Of Transact Body  -->

  </div>
  <!-- End of Transact OffCanvas -->