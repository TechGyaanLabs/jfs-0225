package com.careerit.sb.scopes;

import java.util.List;

public class GetOrderDetails {

        public long[] getOrderIds(long[] ele, Sort sort){
            return sort.sort(ele);
        }
}
