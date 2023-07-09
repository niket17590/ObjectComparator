package com.niket.agrawal.object.comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.niket.agrawal.object.comparator.dto.MobileCompany;
import com.niket.agrawal.object.comparator.dto.MobileModel;
import com.niket.agrawal.object.comparator.entity.MobileApplications;
import com.niket.agrawal.object.comparator.util.EnumConstants.OperatingSystem;
import com.niket.agrawal.object.comparator.util.ObjectComparatorUtil;

@SpringBootTest
class ObjectComparatorApplicationTests {


	@Test
	void testComparison() {

		MobileCompany oneplusCompany = MobileCompany.builder().setCompanyName("Oneplus").setStartYear(2000).build();
		MobileCompany appleCompany = MobileCompany.builder().setCompanyName("Apple").setStartYear(1980)
				.setFounderName("Steve Jobs").build();

		MobileApplications androidApps = MobileApplications.builder().setAppNameList(Arrays.asList("App1", "App2"))
				.setMobileCompany(oneplusCompany).build();
		MobileApplications appleApps = MobileApplications.builder()
				.setAppNameList(Arrays.asList("App1", "App2", "App3")).setMobileCompany(appleCompany).build();

		MobileModel androidModel = MobileModel.builder().setAvailablity(true).setModelName("OnePlus7")
				.setModelPrice(30000L).setOsSystem(OperatingSystem.ANDROID).setVersion(1.0).setMobileApps(androidApps)
				.build();

		MobileModel appleModel = MobileModel.builder().setAvailablity(true).setModelName("Apple6").setModelPrice(70000L)
				.setOsSystem(OperatingSystem.APPLE).setVersion(1.0).setMobileApps(appleApps).build();

		List<String> output = ObjectComparatorUtil.compareAndGetDiff(androidModel, appleModel, "");
		assertEquals(7, output.size());
	}
}
