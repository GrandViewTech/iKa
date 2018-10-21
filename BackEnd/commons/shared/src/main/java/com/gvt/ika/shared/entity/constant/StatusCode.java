package com.gvt.ika.shared.entity.constant;

import com.gvt.ika.shared.entity.dto.Code;

public interface StatusCode {

    public Code HEADER_MISSING = new Code(4001,"Header Missing");

    public Code COMPANY_NOT_FOUND = new Code(4002,"Invalid Company Id");


}
