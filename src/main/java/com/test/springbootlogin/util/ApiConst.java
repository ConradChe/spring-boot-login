package com.test.springbootlogin.util;

public class ApiConst {
    public ApiConst() {
    }

    public static enum Code {
        CODE_SUCCESS(200L),
        CODE_CONTENT_EMPTY(204L),
        CODE_REJECT(403L),
        CODE_NO_AUTH(401L),
        CODE_NOT_EXIST(404L),
        CODE_VERSION_ERROR(406L),
        CODE_GET_LOCK_ERROR(423L),
        CODE_PARAM_ERROR(4001L),
        CODE_SERVER_ERROR(500L),
        CODE_COMMON_ERROR(5001L),
        CODE_LOGIN_RETRY(5002L),
        CODE_NO_SESSION(5003L),
        CODE_THIRDPARTY_ERROR(5004L);

        private Long intCode;

        private Code(Long intCode) {
            this.intCode = intCode;
        }

        public Long code() {
            return this.intCode;
        }
    }
}
