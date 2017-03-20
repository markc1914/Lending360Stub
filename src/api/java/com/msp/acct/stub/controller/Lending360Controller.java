package com.msp.acct.stub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AccountOpening")
public class Lending360Controller {
	private static Logger log = LoggerFactory.getLogger(Lending360Controller.class);
	
	private String jsonStringSubmitApplicationResponse = "{\"NewAccountAppId\":30004281}";
	private String jsonStringAubmitForApplicantResponse = "{\"ApplicationID\":80276918,\"MembershipID\":170,\"ApplicantDecisions\":[{\"FirstName\":\"Anthony\",\"LastName\":\"Dellisanti\",\"SuffixType\":0,\"ApplicationStatus\":6,\"ApplicantType\":1,\"ApplicantID\":11404324,\"SharesID\":null,\"SharesName\":null,\"ShareRelatedProductID\":null,\"ShareRelatedProductName\":null,\"MembershipRelatedProductID\":null,\"MembershipRelatedProductName\":null,\"ApplicantEmail\":\"mark.cornelius@grobanking.com\"}],\"BeneficiaryDecisions\":[],\"FaultMessage\":null}";
	private String jsonStringChallengeQuestionsGetResponse = "{\"OutOfWalletQuestions\": [{\"QuestionChoices\": [{\"IsSelected\": true,\"QuestionChoiceText\": \"STEP ENTERPRISES\",\"QuestionChoiceId\": \"4\"}],\"QuestionText\": \"Which of the following businesses have you been associated with? If there is not a matched business name, please select 'NONE OF THE ABOVE'.\",\"RelativeOrder\": \"1\"},{\"QuestionChoices\": [{\"IsSelected\": true,\"QuestionChoiceText\": \"MITSUBISHI ECLIPSE\",\"QuestionChoiceId\": \"2\"}],\"QuestionText\": \"According to our records, you currently own/lease, or have owned/leased within the past year, one of the following vehicles. Please select the vehicle that you purchased or leased prior to March 2013  from the following choices.\",\"RelativeOrder\": \"2\"},{\"QuestionChoices\": [{\"IsSelected\": true,\"QuestionChoiceText\": \"NONE OF THE ABOVE/DOES NOT APPLY\",\"QuestionChoiceId\": \"5\"}],\"QuestionText\": \"According to your credit profile, you may have opened a Home Equity Line of Credit type loan in or around November 2015. Please select the lender to whom you currently make your payments or made your payments.\",\"RelativeOrder\": \"3\"},{\"QuestionChoices\": [{\"IsSelected\": true,\"QuestionChoiceText\": \"NONE OF THE ABOVE/DOES NOT APPLY\",\"QuestionChoiceId\": \"5\"}],\"QuestionText\": \"According to our records, within the last two years you purchased veterinary insurance for a pet.  For which one of the following pets did you purchase insurance?\",\"RelativeOrder\": \"4\"},{\"QuestionChoices\": [{\"IsSelected\": true,\"QuestionChoiceText\": \"NONE OF THE ABOVE/DOES NOT APPLY\",\"QuestionChoiceId\": \"5\"}],\"QuestionText\": \"Please select the range that includes the credit limit for your credit card ending in (4933).\",\"RelativeOrder\": \"5\"}],\"RequestId\": \"7e8d55a7-1e95-4298-8edb-7c8c7ad2a90a\"}";
	private String jsonStringSubmitChallengeQuestionsRespose ="{ \"RequestId\": \"7e8d55a7-1e95-4298-8edb-7c8c7ad2a90a\", \"PreciseIdFinalDecision\": \"ACC\",\"OutOfWalletQuestions\":[],\"Message\": \"string\"}";

	@RequestMapping(method = RequestMethod.POST, value = "/Applications", produces = "application/json")
	public String submitApplication(@RequestBody String application) {
		log.debug(application);
		return jsonStringSubmitApplicationResponse;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/Applications/{newAccountAppId}/Submit", produces = "application/json")
	public String submitApplicationForApplicantNumber(@PathVariable String newAccountAppId) {
		log.debug(newAccountAppId);
		return jsonStringAubmitForApplicantResponse;
	}
	
	@RequestMapping(method= RequestMethod.GET, value="/Applications/{newAccountAppId}/Applicants/{applicationId}/PreciseId/OutOfWallet/Questions",produces = "application/json")
	public String getChallengeQuestions(@PathVariable String newAccountAppId, @PathVariable String applicationId) {
		return jsonStringChallengeQuestionsGetResponse;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/Applications/{newAccountAppId}/Applicants/{applicantId}/PreciseId/OutOfWallet/Answers", produces = "application/json")
	public String submitChallengeQuestionAnswers(@PathVariable String newAccountAppId, @PathVariable String applicantId, @RequestBody String submission) {
		return this.jsonStringSubmitChallengeQuestionsRespose;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/Applications/{newAccountAppId}/Documents", produces = "application/json")
	public String submitDocuments(@PathVariable String newAccountAppId, @RequestBody Object object){
		log.info(object.toString());
		return "{}";
	}
}
