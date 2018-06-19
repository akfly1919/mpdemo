package com.fly.wechat.mpdemo.match.model;

import java.util.ArrayList;
import java.util.List;

public class MatchTeamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MatchTeamExample() {
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

        public Criteria andMatchIdIsNull() {
            addCriterion("match_id is null");
            return (Criteria) this;
        }

        public Criteria andMatchIdIsNotNull() {
            addCriterion("match_id is not null");
            return (Criteria) this;
        }

        public Criteria andMatchIdEqualTo(String value) {
            addCriterion("match_id =", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotEqualTo(String value) {
            addCriterion("match_id <>", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdGreaterThan(String value) {
            addCriterion("match_id >", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdGreaterThanOrEqualTo(String value) {
            addCriterion("match_id >=", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdLessThan(String value) {
            addCriterion("match_id <", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdLessThanOrEqualTo(String value) {
            addCriterion("match_id <=", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdLike(String value) {
            addCriterion("match_id like", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotLike(String value) {
            addCriterion("match_id not like", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdIn(List<String> values) {
            addCriterion("match_id in", values, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotIn(List<String> values) {
            addCriterion("match_id not in", values, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdBetween(String value1, String value2) {
            addCriterion("match_id between", value1, value2, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotBetween(String value1, String value2) {
            addCriterion("match_id not between", value1, value2, "matchId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNull() {
            addCriterion("team_id is null");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNotNull() {
            addCriterion("team_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeamIdEqualTo(String value) {
            addCriterion("team_id =", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotEqualTo(String value) {
            addCriterion("team_id <>", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThan(String value) {
            addCriterion("team_id >", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThanOrEqualTo(String value) {
            addCriterion("team_id >=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThan(String value) {
            addCriterion("team_id <", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThanOrEqualTo(String value) {
            addCriterion("team_id <=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLike(String value) {
            addCriterion("team_id like", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotLike(String value) {
            addCriterion("team_id not like", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIn(List<String> values) {
            addCriterion("team_id in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotIn(List<String> values) {
            addCriterion("team_id not in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdBetween(String value1, String value2) {
            addCriterion("team_id between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotBetween(String value1, String value2) {
            addCriterion("team_id not between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamWNameIsNull() {
            addCriterion("team_w_name is null");
            return (Criteria) this;
        }

        public Criteria andTeamWNameIsNotNull() {
            addCriterion("team_w_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeamWNameEqualTo(String value) {
            addCriterion("team_w_name =", value, "teamWName");
            return (Criteria) this;
        }

        public Criteria andTeamWNameNotEqualTo(String value) {
            addCriterion("team_w_name <>", value, "teamWName");
            return (Criteria) this;
        }

        public Criteria andTeamWNameGreaterThan(String value) {
            addCriterion("team_w_name >", value, "teamWName");
            return (Criteria) this;
        }

        public Criteria andTeamWNameGreaterThanOrEqualTo(String value) {
            addCriterion("team_w_name >=", value, "teamWName");
            return (Criteria) this;
        }

        public Criteria andTeamWNameLessThan(String value) {
            addCriterion("team_w_name <", value, "teamWName");
            return (Criteria) this;
        }

        public Criteria andTeamWNameLessThanOrEqualTo(String value) {
            addCriterion("team_w_name <=", value, "teamWName");
            return (Criteria) this;
        }

        public Criteria andTeamWNameLike(String value) {
            addCriterion("team_w_name like", value, "teamWName");
            return (Criteria) this;
        }

        public Criteria andTeamWNameNotLike(String value) {
            addCriterion("team_w_name not like", value, "teamWName");
            return (Criteria) this;
        }

        public Criteria andTeamWNameIn(List<String> values) {
            addCriterion("team_w_name in", values, "teamWName");
            return (Criteria) this;
        }

        public Criteria andTeamWNameNotIn(List<String> values) {
            addCriterion("team_w_name not in", values, "teamWName");
            return (Criteria) this;
        }

        public Criteria andTeamWNameBetween(String value1, String value2) {
            addCriterion("team_w_name between", value1, value2, "teamWName");
            return (Criteria) this;
        }

        public Criteria andTeamWNameNotBetween(String value1, String value2) {
            addCriterion("team_w_name not between", value1, value2, "teamWName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andVCountIsNull() {
            addCriterion("v_count is null");
            return (Criteria) this;
        }

        public Criteria andVCountIsNotNull() {
            addCriterion("v_count is not null");
            return (Criteria) this;
        }

        public Criteria andVCountEqualTo(Byte value) {
            addCriterion("v_count =", value, "vCount");
            return (Criteria) this;
        }

        public Criteria andVCountNotEqualTo(Byte value) {
            addCriterion("v_count <>", value, "vCount");
            return (Criteria) this;
        }

        public Criteria andVCountGreaterThan(Byte value) {
            addCriterion("v_count >", value, "vCount");
            return (Criteria) this;
        }

        public Criteria andVCountGreaterThanOrEqualTo(Byte value) {
            addCriterion("v_count >=", value, "vCount");
            return (Criteria) this;
        }

        public Criteria andVCountLessThan(Byte value) {
            addCriterion("v_count <", value, "vCount");
            return (Criteria) this;
        }

        public Criteria andVCountLessThanOrEqualTo(Byte value) {
            addCriterion("v_count <=", value, "vCount");
            return (Criteria) this;
        }

        public Criteria andVCountIn(List<Byte> values) {
            addCriterion("v_count in", values, "vCount");
            return (Criteria) this;
        }

        public Criteria andVCountNotIn(List<Byte> values) {
            addCriterion("v_count not in", values, "vCount");
            return (Criteria) this;
        }

        public Criteria andVCountBetween(Byte value1, Byte value2) {
            addCriterion("v_count between", value1, value2, "vCount");
            return (Criteria) this;
        }

        public Criteria andVCountNotBetween(Byte value1, Byte value2) {
            addCriterion("v_count not between", value1, value2, "vCount");
            return (Criteria) this;
        }

        public Criteria andFCountIsNull() {
            addCriterion("f_count is null");
            return (Criteria) this;
        }

        public Criteria andFCountIsNotNull() {
            addCriterion("f_count is not null");
            return (Criteria) this;
        }

        public Criteria andFCountEqualTo(Byte value) {
            addCriterion("f_count =", value, "fCount");
            return (Criteria) this;
        }

        public Criteria andFCountNotEqualTo(Byte value) {
            addCriterion("f_count <>", value, "fCount");
            return (Criteria) this;
        }

        public Criteria andFCountGreaterThan(Byte value) {
            addCriterion("f_count >", value, "fCount");
            return (Criteria) this;
        }

        public Criteria andFCountGreaterThanOrEqualTo(Byte value) {
            addCriterion("f_count >=", value, "fCount");
            return (Criteria) this;
        }

        public Criteria andFCountLessThan(Byte value) {
            addCriterion("f_count <", value, "fCount");
            return (Criteria) this;
        }

        public Criteria andFCountLessThanOrEqualTo(Byte value) {
            addCriterion("f_count <=", value, "fCount");
            return (Criteria) this;
        }

        public Criteria andFCountIn(List<Byte> values) {
            addCriterion("f_count in", values, "fCount");
            return (Criteria) this;
        }

        public Criteria andFCountNotIn(List<Byte> values) {
            addCriterion("f_count not in", values, "fCount");
            return (Criteria) this;
        }

        public Criteria andFCountBetween(Byte value1, Byte value2) {
            addCriterion("f_count between", value1, value2, "fCount");
            return (Criteria) this;
        }

        public Criteria andFCountNotBetween(Byte value1, Byte value2) {
            addCriterion("f_count not between", value1, value2, "fCount");
            return (Criteria) this;
        }

        public Criteria andQCountIsNull() {
            addCriterion("q_count is null");
            return (Criteria) this;
        }

        public Criteria andQCountIsNotNull() {
            addCriterion("q_count is not null");
            return (Criteria) this;
        }

        public Criteria andQCountEqualTo(Byte value) {
            addCriterion("q_count =", value, "qCount");
            return (Criteria) this;
        }

        public Criteria andQCountNotEqualTo(Byte value) {
            addCriterion("q_count <>", value, "qCount");
            return (Criteria) this;
        }

        public Criteria andQCountGreaterThan(Byte value) {
            addCriterion("q_count >", value, "qCount");
            return (Criteria) this;
        }

        public Criteria andQCountGreaterThanOrEqualTo(Byte value) {
            addCriterion("q_count >=", value, "qCount");
            return (Criteria) this;
        }

        public Criteria andQCountLessThan(Byte value) {
            addCriterion("q_count <", value, "qCount");
            return (Criteria) this;
        }

        public Criteria andQCountLessThanOrEqualTo(Byte value) {
            addCriterion("q_count <=", value, "qCount");
            return (Criteria) this;
        }

        public Criteria andQCountIn(List<Byte> values) {
            addCriterion("q_count in", values, "qCount");
            return (Criteria) this;
        }

        public Criteria andQCountNotIn(List<Byte> values) {
            addCriterion("q_count not in", values, "qCount");
            return (Criteria) this;
        }

        public Criteria andQCountBetween(Byte value1, Byte value2) {
            addCriterion("q_count between", value1, value2, "qCount");
            return (Criteria) this;
        }

        public Criteria andQCountNotBetween(Byte value1, Byte value2) {
            addCriterion("q_count not between", value1, value2, "qCount");
            return (Criteria) this;
        }

        public Criteria andPointIsNull() {
            addCriterion("point is null");
            return (Criteria) this;
        }

        public Criteria andPointIsNotNull() {
            addCriterion("point is not null");
            return (Criteria) this;
        }

        public Criteria andPointEqualTo(String value) {
            addCriterion("point =", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotEqualTo(String value) {
            addCriterion("point <>", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThan(String value) {
            addCriterion("point >", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThanOrEqualTo(String value) {
            addCriterion("point >=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThan(String value) {
            addCriterion("point <", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThanOrEqualTo(String value) {
            addCriterion("point <=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLike(String value) {
            addCriterion("point like", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotLike(String value) {
            addCriterion("point not like", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointIn(List<String> values) {
            addCriterion("point in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotIn(List<String> values) {
            addCriterion("point not in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointBetween(String value1, String value2) {
            addCriterion("point between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotBetween(String value1, String value2) {
            addCriterion("point not between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
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