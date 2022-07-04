let btn = document.querySelector("#btn");
let sidebar = document.querySelector(".sidebar");

let funcmembers = document.querySelector(".funcmembers");
let funcproducts = document.querySelector(".funcproducts");
let funcsupplies = document.querySelector(".funcsupplies");
let funcorders = document.querySelector(".funcorders");

btn.onclick = function() {
	sidebar.classList.toggle("active");
}

funcmembers.onclick = function() {
	window.location.href = '/backstage/pages/MemberControl';
}
funcproducts.onclick = function() {
	window.location.href = '/backstage/pages/Product';
}
funcsupplies.onclick = function() {
	window.location.href = '/backstage/pages/SuppliesDisplay';
}
funcorders.onclick = function() {
	window.location.href = '/backstage/pages/OrdersDisplay';
}

log_out.onclick = function() {
	window.location.href = '/';

}