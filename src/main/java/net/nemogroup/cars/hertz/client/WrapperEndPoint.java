package net.nemogroup.cars.hertz.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WrapperEndPoint {
	
	@Value("${hertz.end-point}")
	private String URL_WS;

	@RequestMapping(value="/listadoDisponibleParcial", method = RequestMethod.GET)
	@ResponseBody
	public String getListado() {
		HttpHeaders headers = new HttpHeaders();
		 
        HttpEntity<String> entity = new HttpEntity<String>("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>           <OTA_VehAvailRateRQ xmlns=\"http://www.opentravel.org/OTA/2003/05\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.opentravel.org/OTA/2003/05 OTA_VehAvailRateRQ.xsd\" Version=\"1.008\" SequenceNmbr=\"484174126\" MaxResponses=\"15\"><POS>   	<Source ISOCountry=\"US\" AgentDutyCode=\"D14N5E13M15\">        	<RequestorID Type=\"4\" ID=\"T923\">            	<CompanyName Code=\"CP\" CodeContext=\"AMTT\"/>            </RequestorID>        </Source>        <Source>        	<RequestorID Type=\"5\" ID=\"00308851\"/>        </Source>	</POS>    <VehAvailRQCore Status=\"All\">    <VehRentalCore PickUpDateTime=\"2019-02-06T12:00:00\" ReturnDateTime=\"2019-02-26T12:00:00\">                        <PickUpLocation CodeContext=\"IATA\" LocationCode=\"ROMC60\"/>                        <ReturnLocation CodeContext=\"IATA\" LocationCode=\"ROMC60\"/>                    </VehRentalCore>                        <RateQualifier TravelPurpose=\"2\" CorpDiscountNmbr=\"1806667\"  RateQualifier=\"BEST\" />                            </VehAvailRQCore>                             </OTA_VehAvailRateRQ>", headers);
 
        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
 
        // Send request with GET method, and Headers.
        ResponseEntity<String> response = restTemplate.exchange(URL_WS, //
                HttpMethod.POST, entity, String.class);
 
        return response.getBody();
        
	}

}
