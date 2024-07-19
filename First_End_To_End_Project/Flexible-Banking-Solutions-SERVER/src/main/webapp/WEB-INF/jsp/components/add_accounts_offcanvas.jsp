  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

  <!-- Start of Right Side Offcanvas -->
  <div class="offcanvas offcanvas-end" data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1"
    id="offcanvasScrolling" aria-labelledby="offcanvasScrollingLabel">
    <div class="offcanvas-header">
      <h5 class="offcanvas-title text-white" id="offcanvasScrollingLabel">Create / Add an Account </h5>
      <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <!-- Offcandas Body -->
    <div class="offcanvas-body">
      <!-- Card: Accounts Form -->
      <div class="card">
        <div class="card-body">
        <!-- Card body -->
        <form action="/account/create_account" method ="POST" class="add-account-form">
          <!-- Form Group -->
          <div class="form-group mb-3">
            <label for="">Enter Account Name</label>
            <input type="text" name="account_name" class="form-control" placeholder="Enter Account name...">
          </div>
          <!-- End Of Form Group -->

          <!-- Form Group -->
          <div class="form-group mb-3">
            <select name="account_type" class="form-control" id="">
              <option value="">-- Select Account Type --</option>
              <option value="check">Check</option>
              <option value="saving">Saving</option>
              <option value="business">Business</option>
            </select>
          </div>
          <!-- End Of Form Group -->

          <!-- Form Group -->
          <div class="form-group mb-3">
            <button id="transact-btn" class="btn btn-md">Add Account</button>
          </div>
          <!-- End Of Form Group -->

        </form>
        <!-- End Of Card Body -->
        </div>
      </div>
      <!-- End Of Card: Accounts Form -->
    </div>
    <!-- End of Offcandas Body -->
  </div>
  <!-- End Of Right Side OffCanvas -->