package com.niket.agrawal.object.comparator.entity;

import java.util.List;
import java.util.Map;

import com.niket.agrawal.object.comparator.dto.MobileCompany;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "set")
public class MobileApplications {

	private List<String> appNameList;
	private Map<String, String> appFeatures;
	private MobileCompany mobileCompany;

}
