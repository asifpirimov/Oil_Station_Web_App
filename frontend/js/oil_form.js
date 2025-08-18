const API_URL = "http://localhost:8080/api/oils";

const form = document.getElementById("oilForm");
const urlParams = new URLSearchParams(window.location.search);
const oilId = urlParams.get("id");

if (oilId) {
  document.getElementById("formTitle").innerText = "Edit Oil";

  fetch(`${API_URL}/${oilId}`)
    .then(res => res.json())
    .then(oil => {
      document.getElementById("oilId").value = oil.id;
      document.getElementById("brandName").value = oil.brandName;
      document.getElementById("productName").value = oil.productName;
      document.getElementById("oilType").value = oil.oilType;
      document.getElementById("viscosityGrade").value = oil.viscosityGrade;
      document.getElementById("price").value = oil.price;
    });
}

form.addEventListener("submit", async (e) => {
  e.preventDefault();

  const oil = {
    brandName: document.getElementById("brandName").value,
    productName: document.getElementById("productName").value,
    oilType: document.getElementById("oilType").value,
    viscosityGrade: document.getElementById("viscosityGrade").value,
    price: parseFloat(document.getElementById("price").value)
  };

  if (oilId) {
    await fetch(`${API_URL}/${oilId}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(oil)
    });
  } else {
    await fetch(API_URL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(oil)
    });
  }

  window.location.href = "oils.html";
});
