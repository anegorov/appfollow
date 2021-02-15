package com.appfollow.aftests.ui;

import com.appfollow.aftests.before.InitTest;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.*;

@Tag("ui-tests")
@SpringBootTest
class RegistrationFormValidationTests extends InitTest {

	@BeforeEach
	private void openStartPage() {
		open(uiBase.getUrl());

		if(startPage.getBtnAdReject().exists())
			startPage.getBtnAdReject().click();

		startPage.getBtnCreateAccount()
				.click();
		registrationPage.getForm()
				.shouldBe();
	}

	@Test
	@DisplayName("Check error message when all fields are empty.")
	void allFieldsEmpty() {
		registrationPage.getBtnSignup()
				.click();
		registrationPage.getMsgError()
				.shouldHave(text("Введите ваш email."));
	}

	@Test
	@DisplayName("Check error message when only not valid email is entered.")
	void onlyNotValidEmailEntered() {
		registrationPage.getInputEmail()
				.setValue("abcd");
		registrationPage.getBtnSignup()
				.click();

		registrationPage.getMsgError()
				.shouldHave(text("Введите ваш email."));
	}

	@Test
	@DisplayName("Check error message when only valid email is entered.")
	void onlyValidEmailEntered() {
		registrationPage.getInputEmail()
				.setValue("abc@c.aa");
		registrationPage.getBtnSignup()
				.click();

		registrationPage.getMsgError()
				.shouldHave(text("Введите имя и фамилию"));
	}

	@Test
	@DisplayName("Check Role field")
	void checkRole() {
		registrationPage.getInputEmail()
				.setValue("abc@c.aa");
		registrationPage.getInputFullName()
				.setValue("A");
		registrationPage.getInputCompany()
				.setValue("Abc");
		registrationPage.getCmbPosition()
				.selectOption("Другое");
		registrationPage.getInputRole()
				.setValue("Aa");
		registrationPage.getBtnSignup()
				.click();

		registrationPage.getMsgError()
				.shouldHave(text("Введите занимаемую должность"));
	}

	@AfterEach
	private void close(){
		Selenide.closeWindow();
	}

}
