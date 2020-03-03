package threadpool;

import java.util.List;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date Entity.java v1.0  2020/1/10 10:49 上午
 */
public class Entity {

    private List<ErrorsBean> errors;

    public List<ErrorsBean> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorsBean> errors) {
        this.errors = errors;
    }

    public static class ErrorsBean {
        /**
         * code : 2106
         * description : Please use secret key, public key given
         */

        private String code;
        private String description;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
