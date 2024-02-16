async function handleLoginClick() {
	
	const inputs = document.querySelectorAll("input");
	
	const loginUser = {
		username: inputs[0].value,
		password: inputs[1].value
	}
	
	try {
		const respose = await fetch("/product/auth/signin", {
			method: "post",
			headers: {
				"Contetn-Type": "application/json"
			},
			body: JSON.stringify(loginUser)
		});
		
		if(!respose.ok) {
			throw await respose.json();
		}
		
		alert("로그인 성공!");
		// 대입만 해줘도 get 요청
		location.href = "/product/home.do";
		
	} catch(error) {
		alert(error?.errorMessage);
	}
}