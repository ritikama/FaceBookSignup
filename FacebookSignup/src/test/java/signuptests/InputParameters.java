package signuptests;

public class InputParameters {
	String gender;
	String firstName;
	String lastName;
	String regEmailId;
	String password;
	String loginType;

	public InputParameters(String firstName, String lastName, String regEmailId, String password, String loginType,
			String gender) {
		super();
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.regEmailId = regEmailId;
		this.password = password;
		this.loginType = loginType;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRegEmailId() {
		return regEmailId;
	}

	public void setRegEmailId(String regEmailId) {
		this.regEmailId = regEmailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "InputParameters [gender=" + gender + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", regEmailId=" + regEmailId + ", password=" + password + ", loginType=" + loginType + "]";
	}

}
