package com.yosanai.web.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.spendingpulse.GasWeekly;
import com.mastercard.api.spendingpulse.Parameters;
import com.mastercard.api.spendingpulse.SpendingPulseReport;
import com.mastercard.api.spendingpulse.Subscription;
import com.yosanai.web.model.BaseRequest;
import com.yosanai.web.model.SpendingPulseRequest;

@RestController
public class SpendingPulseController {

	@RequestMapping(value = "/spendingPulse", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody SpendingPulseReport spendingPulse(@RequestBody SpendingPulseRequest req) throws Exception {
		RequestMap map = new RequestMap();
		map.set("CurrentRow", req.getCurrentRow());
		map.set("Offset", req.getOffset());
		map.set("Country", req.getCountry());
		map.set("Period", req.getPeriod());
		return SpendingPulseReport.query(map);
	}

	@RequestMapping(value = "/gasWeekly", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody GasWeekly gasWeekly(@RequestBody BaseRequest req) throws Exception {
		RequestMap map = new RequestMap();
		map.set("CurrentRow", req.getCurrentRow());
		map.set("Offset", req.getOffset());
		return GasWeekly.query(map);
	}

	@RequestMapping(value = "/parameters", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Parameters parameters(@RequestBody BaseRequest req) throws Exception {
		RequestMap map = new RequestMap();
		map.set("CurrentRow", req.getCurrentRow());
		map.set("Offset", req.getOffset());
		return Parameters.query(map);
	}

	@RequestMapping(value = "/subscriptions", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Subscription subscriptions(@RequestBody BaseRequest req) throws Exception {
		RequestMap map = new RequestMap();
		map.set("CurrentRow", req.getCurrentRow());
		map.set("Offset", req.getOffset());
		return Subscription.query(map);
	}

}
