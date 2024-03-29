function Get_Cookie( check_name ) {
	var a_all_cookies = document.cookie.split( ';' );
	var a_temp_cookie = '';
	var cookie_name = '';  // 쿠키 이름
	var cookie_value = '';  // 쿠키 값
	var b_cookie_found = false; 
	for (var i = 0; i < a_all_cookies.length; i++ ){  // 모든 쿠키 가져 와서 loop
		a_temp_cookie = a_all_cookies[i].split( '=' );  // 쿠키 이름과 값을 나눔
		cookie_name = a_temp_cookie[0].replace(/^\s+|\s+$/g, '');  // [=] 기호 앞의 값을 쿠키
		if ( cookie_name == check_name ){// 이름으로
				b_cookie_found = true;
			if ( a_temp_cookie.length > 1 ){
				// [=] 기호 뒤의 값을 쿠키값으로
				cookie_value = unescape( a_temp_cookie[1].replace(/^\s+|\s+$/g, '') );  
			}
			return cookie_value;  // cookie 값 리턴
			break;
		}
		a_temp_cookie = null; // temp 쿠키를 비워줌
		cookie_name = ''; // 쿠키 이름을 비워줌
	}
	if ( !b_cookie_found ) {
		return null;
	}
}

// 자바스크립트 : 쿠키작성, 취득 시에 활용객체 - document.cookie
//               쿠키작성 : 문자열 기반으로 작성
//                         ex) key=값;유효시간=값;패스=값;도메인=값;
function Set_Cookie( name, value, expires, path, domain, secure ) {
	var today = new Date();
	today.setTime( today.getTime());
	if ( expires ){
		expires = expires * 1000 * 60 * 60 * 24;
	}
	var expires_date = new Date( today.getTime() + (expires) );
	document.cookie = name + "=" +escape( value ) +
				( ( expires ) ? ";expires=" + expires_date.toGMTString() : "" ) +
				( ( path ) ? ";path=" + path : "" ) + 
				( ( domain ) ? ";domain=" + domain : "" ) +
				( ( secure ) ? ";secure" : "" );
}

function Delete_Cookie( name, path, domain ) {
	if ( Get_Cookie( name ) ) document.cookie = name + "=" +
		( ( path ) ? ";path=" + path : "") +
		( ( domain ) ? ";domain=" + domain : "" ) +
		";expires=Thu, 01-Jan-1970 00:00:01 GMT";
}



