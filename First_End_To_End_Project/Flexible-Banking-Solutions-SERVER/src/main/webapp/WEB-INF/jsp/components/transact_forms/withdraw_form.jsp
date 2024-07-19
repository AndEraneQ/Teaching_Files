<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!-- Card: Withdraw Card -->
      <div class="card withdraw-card">
        <!-- Card Body -->
        <div class="card-body">

          <!-- withdraw Form -->
          <form action ="/transact/withdraw" method="POST" class="withdraw-form">
            <!-- Form Group -->
            <div class="form-group mb-2">
              <label for="">Enter Withdraw Amount</label>
              <input type="text" name="withdraw_amount" class="form-control" placeholder="Enter Withdraw Amount">
            </div>
            <!-- End Of Form Group -->

            <!-- Form Group -->
            <div class="form-group">
              <label for="">Select Account</label>
                <!-- Select Account Option -->
                <select name="account_id" class="form-control" id="">
                  <option value="">-- Select Account --</option>
                    <c:if test ="${userAccounts != null}">
                      <c:forEach items="${userAccounts}" var = "selectAccount">
                         <option value="${selectAccount.account_id}">${selectAccount.account_name}</option>
                      </c:forEach>
                    </c:if>
                </select>
            </div>
            <!-- End Of Group -->

            <!-- Form Group -->
            <div class="form-group my-2">
              <button id="transact-btn" class="btn btn-md">Withdraw</button>
            </div>
            <!-- End Of Form Group -->
          </form>
          <!-- End of withdraw form -->

        </div>
        <!-- End Of Card Body -->

      </div>
      <!-- End Of Card: withdraw Card -->