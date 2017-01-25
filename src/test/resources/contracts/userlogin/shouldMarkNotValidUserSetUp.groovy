package contracts

org.springframework.cloud.contract.spec.Contract.make {
	request { 
		method 'PUT'
		url '/userlogin'
		body([ 
			   username: 'vinay',
			   password: '321'
		])
		headers {
			contentType('application/json')
		}
	}
	response { 
		status 200 
		body([ 
			   userLoginCheckStatus : 'NOT_OKAY',
			   rejectionReason: 'INCORRECT_PASSWORD'
		])
		headers {
			contentType('application/json')
		}
	}
}
