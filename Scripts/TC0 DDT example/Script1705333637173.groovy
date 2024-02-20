import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.setText(findTestObject('Object Repository/Contact Form/FirstName_Field'), firstname)

if(lastname != "vide") WebUI.setText(findTestObject('Object Repository/Contact Form/LastName_Field'), lastname)
	
if(email != "vide") WebUI.setText(findTestObject('Object Repository/Contact Form/Email_Field'), email)

WebUI.setText(findTestObject('Object Repository/Contact Form/Subject_Field'), subject)

if(message != "vide") WebUI.setText(findTestObject('Object Repository/Contact Form/Message_Field'), message)

WebUI.click(findTestObject('Contact Form/SendMessage_Button'))

object = null;

switch(messageToCheck) {
	case "validationMessage": object = findTestObject('Object Repository/Validation Page/MessageSend_Text')
		break
	case "lastNameMissingMessage": object = findTestObject('Object Repository/Contact Form/LastNameRequired_Text')
		break
	case "emailMissingMessage": object = findTestObject('Object Repository/Contact Form/EmailRequired_Text')
		break
	case "messageMissingMessage": object = findTestObject('Object Repository/Contact Form/MessageRequired_Text')
		break
}

WebUI.verifyElementPresent(object, 0)
WebUI.verifyElementText(object, messageValue)