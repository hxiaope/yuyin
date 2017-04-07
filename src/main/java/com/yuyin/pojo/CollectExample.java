package com.yuyin.pojo;

import java.util.ArrayList;
import java.util.List;

public class CollectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollectExample() {
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

        public Criteria andSingleIdIsNull() {
            addCriterion("single_id is null");
            return (Criteria) this;
        }

        public Criteria andSingleIdIsNotNull() {
            addCriterion("single_id is not null");
            return (Criteria) this;
        }

        public Criteria andSingleIdEqualTo(Long value) {
            addCriterion("single_id =", value, "singleId");
            return (Criteria) this;
        }

        public Criteria andSingleIdNotEqualTo(Long value) {
            addCriterion("single_id <>", value, "singleId");
            return (Criteria) this;
        }

        public Criteria andSingleIdGreaterThan(Long value) {
            addCriterion("single_id >", value, "singleId");
            return (Criteria) this;
        }

        public Criteria andSingleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("single_id >=", value, "singleId");
            return (Criteria) this;
        }

        public Criteria andSingleIdLessThan(Long value) {
            addCriterion("single_id <", value, "singleId");
            return (Criteria) this;
        }

        public Criteria andSingleIdLessThanOrEqualTo(Long value) {
            addCriterion("single_id <=", value, "singleId");
            return (Criteria) this;
        }

        public Criteria andSingleIdIn(List<Long> values) {
            addCriterion("single_id in", values, "singleId");
            return (Criteria) this;
        }

        public Criteria andSingleIdNotIn(List<Long> values) {
            addCriterion("single_id not in", values, "singleId");
            return (Criteria) this;
        }

        public Criteria andSingleIdBetween(Long value1, Long value2) {
            addCriterion("single_id between", value1, value2, "singleId");
            return (Criteria) this;
        }

        public Criteria andSingleIdNotBetween(Long value1, Long value2) {
            addCriterion("single_id not between", value1, value2, "singleId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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