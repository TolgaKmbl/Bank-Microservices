package com.tolgakmbl.customerservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name="blacklist-service", url="localhost:9000")
@FeignClient(name="blacklist-service")
public interface BlacklistServiceProxy {

	@GetMapping("/blacklist")
	public Boolean isBlacklisted();
	
}
