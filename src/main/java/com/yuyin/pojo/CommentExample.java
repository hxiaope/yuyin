package com.yuyin.pojo;

import java.util.ArrayList;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdIsNull() {
            addCriterion("periodical_id is null");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdIsNotNull() {
            addCriterion("periodical_id is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdEqualTo(Long value) {
            addCriterion("periodical_id =", value, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdNotEqualTo(Long value) {
            addCriterion("periodical_id <>", value, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdGreaterThan(Long value) {
            addCriterion("periodical_id >", value, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdGreaterThanOrEqualTo(Long value) {
            addCriterion("periodical_id >=", value, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdLessThan(Long value) {
            addCriterion("periodical_id <", value, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdLessThanOrEqualTo(Long value) {
            addCriterion("periodical_id <=", value, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdIn(List<Long> values) {
            addCriterion("periodical_id in", values, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdNotIn(List<Long> values) {
            addCriterion("periodical_id not in", values, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdBetween(Long value1, Long value2) {
            addCriterion("periodical_id between", value1, value2, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdNotBetween(Long value1, Long value2) {
            addCriterion("periodical_id not between", value1, value2, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andEssaysIdIsNull() {
            addCriterion("essays_id is null");
            return (Criteria) this;
        }

        public Criteria andEssaysIdIsNotNull() {
            addCriterion("essays_id is not null");
            return (Criteria) this;
        }

        public Criteria andEssaysIdEqualTo(Long value) {
            addCriterion("essays_id =", value, "essaysId");
            return (Criteria) this;
        }

        public Criteria andEssaysIdNotEqualTo(Long value) {
            addCriterion("essays_id <>", value, "essaysId");
            return (Criteria) this;
        }

        public Criteria andEssaysIdGreaterThan(Long value) {
            addCriterion("essays_id >", value, "essaysId");
            return (Criteria) this;
        }

        public Criteria andEssaysIdGreaterThanOrEqualTo(Long value) {
            addCriterion("essays_id >=", value, "essaysId");
            return (Criteria) this;
        }

        public Criteria andEssaysIdLessThan(Long value) {
            addCriterion("essays_id <", value, "essaysId");
            return (Criteria) this;
        }

        public Criteria andEssaysIdLessThanOrEqualTo(Long value) {
            addCriterion("essays_id <=", value, "essaysId");
            return (Criteria) this;
        }

        public Criteria andEssaysIdIn(List<Long> values) {
            addCriterion("essays_id in", values, "essaysId");
            return (Criteria) this;
        }

        public Criteria andEssaysIdNotIn(List<Long> values) {
            addCriterion("essays_id not in", values, "essaysId");
            return (Criteria) this;
        }

        public Criteria andEssaysIdBetween(Long value1, Long value2) {
            addCriterion("essays_id between", value1, value2, "essaysId");
            return (Criteria) this;
        }

        public Criteria andEssaysIdNotBetween(Long value1, Long value2) {
            addCriterion("essays_id not between", value1, value2, "essaysId");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createtime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createtime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andFormUserIsNull() {
            addCriterion("form_user is null");
            return (Criteria) this;
        }

        public Criteria andFormUserIsNotNull() {
            addCriterion("form_user is not null");
            return (Criteria) this;
        }

        public Criteria andFormUserEqualTo(String value) {
            addCriterion("form_user =", value, "formUser");
            return (Criteria) this;
        }

        public Criteria andFormUserNotEqualTo(String value) {
            addCriterion("form_user <>", value, "formUser");
            return (Criteria) this;
        }

        public Criteria andFormUserGreaterThan(String value) {
            addCriterion("form_user >", value, "formUser");
            return (Criteria) this;
        }

        public Criteria andFormUserGreaterThanOrEqualTo(String value) {
            addCriterion("form_user >=", value, "formUser");
            return (Criteria) this;
        }

        public Criteria andFormUserLessThan(String value) {
            addCriterion("form_user <", value, "formUser");
            return (Criteria) this;
        }

        public Criteria andFormUserLessThanOrEqualTo(String value) {
            addCriterion("form_user <=", value, "formUser");
            return (Criteria) this;
        }

        public Criteria andFormUserLike(String value) {
            addCriterion("form_user like", value, "formUser");
            return (Criteria) this;
        }

        public Criteria andFormUserNotLike(String value) {
            addCriterion("form_user not like", value, "formUser");
            return (Criteria) this;
        }

        public Criteria andFormUserIn(List<String> values) {
            addCriterion("form_user in", values, "formUser");
            return (Criteria) this;
        }

        public Criteria andFormUserNotIn(List<String> values) {
            addCriterion("form_user not in", values, "formUser");
            return (Criteria) this;
        }

        public Criteria andFormUserBetween(String value1, String value2) {
            addCriterion("form_user between", value1, value2, "formUser");
            return (Criteria) this;
        }

        public Criteria andFormUserNotBetween(String value1, String value2) {
            addCriterion("form_user not between", value1, value2, "formUser");
            return (Criteria) this;
        }

        public Criteria andToUserIsNull() {
            addCriterion("to_user is null");
            return (Criteria) this;
        }

        public Criteria andToUserIsNotNull() {
            addCriterion("to_user is not null");
            return (Criteria) this;
        }

        public Criteria andToUserEqualTo(String value) {
            addCriterion("to_user =", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotEqualTo(String value) {
            addCriterion("to_user <>", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserGreaterThan(String value) {
            addCriterion("to_user >", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserGreaterThanOrEqualTo(String value) {
            addCriterion("to_user >=", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserLessThan(String value) {
            addCriterion("to_user <", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserLessThanOrEqualTo(String value) {
            addCriterion("to_user <=", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserLike(String value) {
            addCriterion("to_user like", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotLike(String value) {
            addCriterion("to_user not like", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserIn(List<String> values) {
            addCriterion("to_user in", values, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotIn(List<String> values) {
            addCriterion("to_user not in", values, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserBetween(String value1, String value2) {
            addCriterion("to_user between", value1, value2, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotBetween(String value1, String value2) {
            addCriterion("to_user not between", value1, value2, "toUser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}