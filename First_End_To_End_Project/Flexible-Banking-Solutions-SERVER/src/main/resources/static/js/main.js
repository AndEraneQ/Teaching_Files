
// Get Transaction Type:
const transferType = document.querySelector("#transact-type");
// Get Transaction Forms:
const paymentCard = document.querySelector(".payment-card");
const transferCard = document.querySelector(".transfer-card");
const depositCard = document.querySelector(".deposit-card");
const withdrawCard = document.querySelector(".withdraw-card");
// Check For Transaction type Event Listener
transferType.addEventListener("change", ()=>{
    // Check for Transaction type and Display Form:
    switch(transferType.value){
        case "payment":
            depositCard.style.display = "none";
            withdrawCard.style.display = "none";
            paymentCard.style.display = "block";
            paymentCard.nextElementSibling.style.display = "none";    
            break;
        case "transfer":
            withdrawCard.style.display = "none";
            transferCard.previousElementSibling.style.display = "none";
            transferCard.style.display = "block";
            transferCard.nextElementSibling.style.display = "none";
            break;
        case "deposit":
            paymentCard.style.display = "none";
            depositCard.previousElementSibling.style.display = "none";
            depositCard.style.display = "block";
            depositCard.nextElementSibling.style.display = "none";
            break;
        case "withdraw":
            paymentCard.style.display = "none";
            transferCard.style.display = "none";
            withdrawCard.previousElementSibling.style.display = "none";
            withdrawCard.style.display = "block";
        break;
    }
    // End Of Check for Transaction type and Display Form:
})
// End Of Check For Transaction type Event Listener