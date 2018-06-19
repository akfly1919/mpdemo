package com.fly.wechat.mpdemo.match.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GamePlayerDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GamePlayerDetailExample() {
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

        public Criteria andGameIdIsNull() {
            addCriterion("game_id is null");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNotNull() {
            addCriterion("game_id is not null");
            return (Criteria) this;
        }

        public Criteria andGameIdEqualTo(Long value) {
            addCriterion("game_id =", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotEqualTo(Long value) {
            addCriterion("game_id <>", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThan(Long value) {
            addCriterion("game_id >", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThanOrEqualTo(Long value) {
            addCriterion("game_id >=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThan(Long value) {
            addCriterion("game_id <", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThanOrEqualTo(Long value) {
            addCriterion("game_id <=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdIn(List<Long> values) {
            addCriterion("game_id in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotIn(List<Long> values) {
            addCriterion("game_id not in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdBetween(Long value1, Long value2) {
            addCriterion("game_id between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotBetween(Long value1, Long value2) {
            addCriterion("game_id not between", value1, value2, "gameId");
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

        public Criteria andTeamIdEqualTo(Long value) {
            addCriterion("team_id =", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotEqualTo(Long value) {
            addCriterion("team_id <>", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThan(Long value) {
            addCriterion("team_id >", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThanOrEqualTo(Long value) {
            addCriterion("team_id >=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThan(Long value) {
            addCriterion("team_id <", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThanOrEqualTo(Long value) {
            addCriterion("team_id <=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIn(List<Long> values) {
            addCriterion("team_id in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotIn(List<Long> values) {
            addCriterion("team_id not in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdBetween(Long value1, Long value2) {
            addCriterion("team_id between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotBetween(Long value1, Long value2) {
            addCriterion("team_id not between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIsNull() {
            addCriterion("player_id is null");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIsNotNull() {
            addCriterion("player_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerIdEqualTo(Long value) {
            addCriterion("player_id =", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotEqualTo(Long value) {
            addCriterion("player_id <>", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdGreaterThan(Long value) {
            addCriterion("player_id >", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("player_id >=", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdLessThan(Long value) {
            addCriterion("player_id <", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdLessThanOrEqualTo(Long value) {
            addCriterion("player_id <=", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIn(List<Long> values) {
            addCriterion("player_id in", values, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotIn(List<Long> values) {
            addCriterion("player_id not in", values, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdBetween(Long value1, Long value2) {
            addCriterion("player_id between", value1, value2, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotBetween(Long value1, Long value2) {
            addCriterion("player_id not between", value1, value2, "playerId");
            return (Criteria) this;
        }

        public Criteria andSfIsNull() {
            addCriterion("sf is null");
            return (Criteria) this;
        }

        public Criteria andSfIsNotNull() {
            addCriterion("sf is not null");
            return (Criteria) this;
        }

        public Criteria andSfEqualTo(Byte value) {
            addCriterion("sf =", value, "sf");
            return (Criteria) this;
        }

        public Criteria andSfNotEqualTo(Byte value) {
            addCriterion("sf <>", value, "sf");
            return (Criteria) this;
        }

        public Criteria andSfGreaterThan(Byte value) {
            addCriterion("sf >", value, "sf");
            return (Criteria) this;
        }

        public Criteria andSfGreaterThanOrEqualTo(Byte value) {
            addCriterion("sf >=", value, "sf");
            return (Criteria) this;
        }

        public Criteria andSfLessThan(Byte value) {
            addCriterion("sf <", value, "sf");
            return (Criteria) this;
        }

        public Criteria andSfLessThanOrEqualTo(Byte value) {
            addCriterion("sf <=", value, "sf");
            return (Criteria) this;
        }

        public Criteria andSfIn(List<Byte> values) {
            addCriterion("sf in", values, "sf");
            return (Criteria) this;
        }

        public Criteria andSfNotIn(List<Byte> values) {
            addCriterion("sf not in", values, "sf");
            return (Criteria) this;
        }

        public Criteria andSfBetween(Byte value1, Byte value2) {
            addCriterion("sf between", value1, value2, "sf");
            return (Criteria) this;
        }

        public Criteria andSfNotBetween(Byte value1, Byte value2) {
            addCriterion("sf not between", value1, value2, "sf");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Byte value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Byte value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Byte value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Byte value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Byte value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Byte value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Byte> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Byte> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Byte value1, Byte value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Byte value1, Byte value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andMinIsNull() {
            addCriterion("min is null");
            return (Criteria) this;
        }

        public Criteria andMinIsNotNull() {
            addCriterion("min is not null");
            return (Criteria) this;
        }

        public Criteria andMinEqualTo(Byte value) {
            addCriterion("min =", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotEqualTo(Byte value) {
            addCriterion("min <>", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinGreaterThan(Byte value) {
            addCriterion("min >", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinGreaterThanOrEqualTo(Byte value) {
            addCriterion("min >=", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinLessThan(Byte value) {
            addCriterion("min <", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinLessThanOrEqualTo(Byte value) {
            addCriterion("min <=", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinIn(List<Byte> values) {
            addCriterion("min in", values, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotIn(List<Byte> values) {
            addCriterion("min not in", values, "min");
            return (Criteria) this;
        }

        public Criteria andMinBetween(Byte value1, Byte value2) {
            addCriterion("min between", value1, value2, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotBetween(Byte value1, Byte value2) {
            addCriterion("min not between", value1, value2, "min");
            return (Criteria) this;
        }

        public Criteria andFgIsNull() {
            addCriterion("fg is null");
            return (Criteria) this;
        }

        public Criteria andFgIsNotNull() {
            addCriterion("fg is not null");
            return (Criteria) this;
        }

        public Criteria andFgEqualTo(Byte value) {
            addCriterion("fg =", value, "fg");
            return (Criteria) this;
        }

        public Criteria andFgNotEqualTo(Byte value) {
            addCriterion("fg <>", value, "fg");
            return (Criteria) this;
        }

        public Criteria andFgGreaterThan(Byte value) {
            addCriterion("fg >", value, "fg");
            return (Criteria) this;
        }

        public Criteria andFgGreaterThanOrEqualTo(Byte value) {
            addCriterion("fg >=", value, "fg");
            return (Criteria) this;
        }

        public Criteria andFgLessThan(Byte value) {
            addCriterion("fg <", value, "fg");
            return (Criteria) this;
        }

        public Criteria andFgLessThanOrEqualTo(Byte value) {
            addCriterion("fg <=", value, "fg");
            return (Criteria) this;
        }

        public Criteria andFgIn(List<Byte> values) {
            addCriterion("fg in", values, "fg");
            return (Criteria) this;
        }

        public Criteria andFgNotIn(List<Byte> values) {
            addCriterion("fg not in", values, "fg");
            return (Criteria) this;
        }

        public Criteria andFgBetween(Byte value1, Byte value2) {
            addCriterion("fg between", value1, value2, "fg");
            return (Criteria) this;
        }

        public Criteria andFgNotBetween(Byte value1, Byte value2) {
            addCriterion("fg not between", value1, value2, "fg");
            return (Criteria) this;
        }

        public Criteria andFgtIsNull() {
            addCriterion("fgt is null");
            return (Criteria) this;
        }

        public Criteria andFgtIsNotNull() {
            addCriterion("fgt is not null");
            return (Criteria) this;
        }

        public Criteria andFgtEqualTo(Byte value) {
            addCriterion("fgt =", value, "fgt");
            return (Criteria) this;
        }

        public Criteria andFgtNotEqualTo(Byte value) {
            addCriterion("fgt <>", value, "fgt");
            return (Criteria) this;
        }

        public Criteria andFgtGreaterThan(Byte value) {
            addCriterion("fgt >", value, "fgt");
            return (Criteria) this;
        }

        public Criteria andFgtGreaterThanOrEqualTo(Byte value) {
            addCriterion("fgt >=", value, "fgt");
            return (Criteria) this;
        }

        public Criteria andFgtLessThan(Byte value) {
            addCriterion("fgt <", value, "fgt");
            return (Criteria) this;
        }

        public Criteria andFgtLessThanOrEqualTo(Byte value) {
            addCriterion("fgt <=", value, "fgt");
            return (Criteria) this;
        }

        public Criteria andFgtIn(List<Byte> values) {
            addCriterion("fgt in", values, "fgt");
            return (Criteria) this;
        }

        public Criteria andFgtNotIn(List<Byte> values) {
            addCriterion("fgt not in", values, "fgt");
            return (Criteria) this;
        }

        public Criteria andFgtBetween(Byte value1, Byte value2) {
            addCriterion("fgt between", value1, value2, "fgt");
            return (Criteria) this;
        }

        public Criteria andFgtNotBetween(Byte value1, Byte value2) {
            addCriterion("fgt not between", value1, value2, "fgt");
            return (Criteria) this;
        }

        public Criteria andPt3IsNull() {
            addCriterion("pt3 is null");
            return (Criteria) this;
        }

        public Criteria andPt3IsNotNull() {
            addCriterion("pt3 is not null");
            return (Criteria) this;
        }

        public Criteria andPt3EqualTo(Byte value) {
            addCriterion("pt3 =", value, "pt3");
            return (Criteria) this;
        }

        public Criteria andPt3NotEqualTo(Byte value) {
            addCriterion("pt3 <>", value, "pt3");
            return (Criteria) this;
        }

        public Criteria andPt3GreaterThan(Byte value) {
            addCriterion("pt3 >", value, "pt3");
            return (Criteria) this;
        }

        public Criteria andPt3GreaterThanOrEqualTo(Byte value) {
            addCriterion("pt3 >=", value, "pt3");
            return (Criteria) this;
        }

        public Criteria andPt3LessThan(Byte value) {
            addCriterion("pt3 <", value, "pt3");
            return (Criteria) this;
        }

        public Criteria andPt3LessThanOrEqualTo(Byte value) {
            addCriterion("pt3 <=", value, "pt3");
            return (Criteria) this;
        }

        public Criteria andPt3In(List<Byte> values) {
            addCriterion("pt3 in", values, "pt3");
            return (Criteria) this;
        }

        public Criteria andPt3NotIn(List<Byte> values) {
            addCriterion("pt3 not in", values, "pt3");
            return (Criteria) this;
        }

        public Criteria andPt3Between(Byte value1, Byte value2) {
            addCriterion("pt3 between", value1, value2, "pt3");
            return (Criteria) this;
        }

        public Criteria andPt3NotBetween(Byte value1, Byte value2) {
            addCriterion("pt3 not between", value1, value2, "pt3");
            return (Criteria) this;
        }

        public Criteria andPt3tIsNull() {
            addCriterion("pt3t is null");
            return (Criteria) this;
        }

        public Criteria andPt3tIsNotNull() {
            addCriterion("pt3t is not null");
            return (Criteria) this;
        }

        public Criteria andPt3tEqualTo(Byte value) {
            addCriterion("pt3t =", value, "pt3t");
            return (Criteria) this;
        }

        public Criteria andPt3tNotEqualTo(Byte value) {
            addCriterion("pt3t <>", value, "pt3t");
            return (Criteria) this;
        }

        public Criteria andPt3tGreaterThan(Byte value) {
            addCriterion("pt3t >", value, "pt3t");
            return (Criteria) this;
        }

        public Criteria andPt3tGreaterThanOrEqualTo(Byte value) {
            addCriterion("pt3t >=", value, "pt3t");
            return (Criteria) this;
        }

        public Criteria andPt3tLessThan(Byte value) {
            addCriterion("pt3t <", value, "pt3t");
            return (Criteria) this;
        }

        public Criteria andPt3tLessThanOrEqualTo(Byte value) {
            addCriterion("pt3t <=", value, "pt3t");
            return (Criteria) this;
        }

        public Criteria andPt3tIn(List<Byte> values) {
            addCriterion("pt3t in", values, "pt3t");
            return (Criteria) this;
        }

        public Criteria andPt3tNotIn(List<Byte> values) {
            addCriterion("pt3t not in", values, "pt3t");
            return (Criteria) this;
        }

        public Criteria andPt3tBetween(Byte value1, Byte value2) {
            addCriterion("pt3t between", value1, value2, "pt3t");
            return (Criteria) this;
        }

        public Criteria andPt3tNotBetween(Byte value1, Byte value2) {
            addCriterion("pt3t not between", value1, value2, "pt3t");
            return (Criteria) this;
        }

        public Criteria andFtIsNull() {
            addCriterion("ft is null");
            return (Criteria) this;
        }

        public Criteria andFtIsNotNull() {
            addCriterion("ft is not null");
            return (Criteria) this;
        }

        public Criteria andFtEqualTo(Byte value) {
            addCriterion("ft =", value, "ft");
            return (Criteria) this;
        }

        public Criteria andFtNotEqualTo(Byte value) {
            addCriterion("ft <>", value, "ft");
            return (Criteria) this;
        }

        public Criteria andFtGreaterThan(Byte value) {
            addCriterion("ft >", value, "ft");
            return (Criteria) this;
        }

        public Criteria andFtGreaterThanOrEqualTo(Byte value) {
            addCriterion("ft >=", value, "ft");
            return (Criteria) this;
        }

        public Criteria andFtLessThan(Byte value) {
            addCriterion("ft <", value, "ft");
            return (Criteria) this;
        }

        public Criteria andFtLessThanOrEqualTo(Byte value) {
            addCriterion("ft <=", value, "ft");
            return (Criteria) this;
        }

        public Criteria andFtIn(List<Byte> values) {
            addCriterion("ft in", values, "ft");
            return (Criteria) this;
        }

        public Criteria andFtNotIn(List<Byte> values) {
            addCriterion("ft not in", values, "ft");
            return (Criteria) this;
        }

        public Criteria andFtBetween(Byte value1, Byte value2) {
            addCriterion("ft between", value1, value2, "ft");
            return (Criteria) this;
        }

        public Criteria andFtNotBetween(Byte value1, Byte value2) {
            addCriterion("ft not between", value1, value2, "ft");
            return (Criteria) this;
        }

        public Criteria andFttIsNull() {
            addCriterion("ftt is null");
            return (Criteria) this;
        }

        public Criteria andFttIsNotNull() {
            addCriterion("ftt is not null");
            return (Criteria) this;
        }

        public Criteria andFttEqualTo(Byte value) {
            addCriterion("ftt =", value, "ftt");
            return (Criteria) this;
        }

        public Criteria andFttNotEqualTo(Byte value) {
            addCriterion("ftt <>", value, "ftt");
            return (Criteria) this;
        }

        public Criteria andFttGreaterThan(Byte value) {
            addCriterion("ftt >", value, "ftt");
            return (Criteria) this;
        }

        public Criteria andFttGreaterThanOrEqualTo(Byte value) {
            addCriterion("ftt >=", value, "ftt");
            return (Criteria) this;
        }

        public Criteria andFttLessThan(Byte value) {
            addCriterion("ftt <", value, "ftt");
            return (Criteria) this;
        }

        public Criteria andFttLessThanOrEqualTo(Byte value) {
            addCriterion("ftt <=", value, "ftt");
            return (Criteria) this;
        }

        public Criteria andFttIn(List<Byte> values) {
            addCriterion("ftt in", values, "ftt");
            return (Criteria) this;
        }

        public Criteria andFttNotIn(List<Byte> values) {
            addCriterion("ftt not in", values, "ftt");
            return (Criteria) this;
        }

        public Criteria andFttBetween(Byte value1, Byte value2) {
            addCriterion("ftt between", value1, value2, "ftt");
            return (Criteria) this;
        }

        public Criteria andFttNotBetween(Byte value1, Byte value2) {
            addCriterion("ftt not between", value1, value2, "ftt");
            return (Criteria) this;
        }

        public Criteria andOrebIsNull() {
            addCriterion("oreb is null");
            return (Criteria) this;
        }

        public Criteria andOrebIsNotNull() {
            addCriterion("oreb is not null");
            return (Criteria) this;
        }

        public Criteria andOrebEqualTo(Byte value) {
            addCriterion("oreb =", value, "oreb");
            return (Criteria) this;
        }

        public Criteria andOrebNotEqualTo(Byte value) {
            addCriterion("oreb <>", value, "oreb");
            return (Criteria) this;
        }

        public Criteria andOrebGreaterThan(Byte value) {
            addCriterion("oreb >", value, "oreb");
            return (Criteria) this;
        }

        public Criteria andOrebGreaterThanOrEqualTo(Byte value) {
            addCriterion("oreb >=", value, "oreb");
            return (Criteria) this;
        }

        public Criteria andOrebLessThan(Byte value) {
            addCriterion("oreb <", value, "oreb");
            return (Criteria) this;
        }

        public Criteria andOrebLessThanOrEqualTo(Byte value) {
            addCriterion("oreb <=", value, "oreb");
            return (Criteria) this;
        }

        public Criteria andOrebIn(List<Byte> values) {
            addCriterion("oreb in", values, "oreb");
            return (Criteria) this;
        }

        public Criteria andOrebNotIn(List<Byte> values) {
            addCriterion("oreb not in", values, "oreb");
            return (Criteria) this;
        }

        public Criteria andOrebBetween(Byte value1, Byte value2) {
            addCriterion("oreb between", value1, value2, "oreb");
            return (Criteria) this;
        }

        public Criteria andOrebNotBetween(Byte value1, Byte value2) {
            addCriterion("oreb not between", value1, value2, "oreb");
            return (Criteria) this;
        }

        public Criteria andDrebIsNull() {
            addCriterion("dreb is null");
            return (Criteria) this;
        }

        public Criteria andDrebIsNotNull() {
            addCriterion("dreb is not null");
            return (Criteria) this;
        }

        public Criteria andDrebEqualTo(Byte value) {
            addCriterion("dreb =", value, "dreb");
            return (Criteria) this;
        }

        public Criteria andDrebNotEqualTo(Byte value) {
            addCriterion("dreb <>", value, "dreb");
            return (Criteria) this;
        }

        public Criteria andDrebGreaterThan(Byte value) {
            addCriterion("dreb >", value, "dreb");
            return (Criteria) this;
        }

        public Criteria andDrebGreaterThanOrEqualTo(Byte value) {
            addCriterion("dreb >=", value, "dreb");
            return (Criteria) this;
        }

        public Criteria andDrebLessThan(Byte value) {
            addCriterion("dreb <", value, "dreb");
            return (Criteria) this;
        }

        public Criteria andDrebLessThanOrEqualTo(Byte value) {
            addCriterion("dreb <=", value, "dreb");
            return (Criteria) this;
        }

        public Criteria andDrebIn(List<Byte> values) {
            addCriterion("dreb in", values, "dreb");
            return (Criteria) this;
        }

        public Criteria andDrebNotIn(List<Byte> values) {
            addCriterion("dreb not in", values, "dreb");
            return (Criteria) this;
        }

        public Criteria andDrebBetween(Byte value1, Byte value2) {
            addCriterion("dreb between", value1, value2, "dreb");
            return (Criteria) this;
        }

        public Criteria andDrebNotBetween(Byte value1, Byte value2) {
            addCriterion("dreb not between", value1, value2, "dreb");
            return (Criteria) this;
        }

        public Criteria andRebIsNull() {
            addCriterion("reb is null");
            return (Criteria) this;
        }

        public Criteria andRebIsNotNull() {
            addCriterion("reb is not null");
            return (Criteria) this;
        }

        public Criteria andRebEqualTo(Byte value) {
            addCriterion("reb =", value, "reb");
            return (Criteria) this;
        }

        public Criteria andRebNotEqualTo(Byte value) {
            addCriterion("reb <>", value, "reb");
            return (Criteria) this;
        }

        public Criteria andRebGreaterThan(Byte value) {
            addCriterion("reb >", value, "reb");
            return (Criteria) this;
        }

        public Criteria andRebGreaterThanOrEqualTo(Byte value) {
            addCriterion("reb >=", value, "reb");
            return (Criteria) this;
        }

        public Criteria andRebLessThan(Byte value) {
            addCriterion("reb <", value, "reb");
            return (Criteria) this;
        }

        public Criteria andRebLessThanOrEqualTo(Byte value) {
            addCriterion("reb <=", value, "reb");
            return (Criteria) this;
        }

        public Criteria andRebIn(List<Byte> values) {
            addCriterion("reb in", values, "reb");
            return (Criteria) this;
        }

        public Criteria andRebNotIn(List<Byte> values) {
            addCriterion("reb not in", values, "reb");
            return (Criteria) this;
        }

        public Criteria andRebBetween(Byte value1, Byte value2) {
            addCriterion("reb between", value1, value2, "reb");
            return (Criteria) this;
        }

        public Criteria andRebNotBetween(Byte value1, Byte value2) {
            addCriterion("reb not between", value1, value2, "reb");
            return (Criteria) this;
        }

        public Criteria andAstIsNull() {
            addCriterion("ast is null");
            return (Criteria) this;
        }

        public Criteria andAstIsNotNull() {
            addCriterion("ast is not null");
            return (Criteria) this;
        }

        public Criteria andAstEqualTo(Byte value) {
            addCriterion("ast =", value, "ast");
            return (Criteria) this;
        }

        public Criteria andAstNotEqualTo(Byte value) {
            addCriterion("ast <>", value, "ast");
            return (Criteria) this;
        }

        public Criteria andAstGreaterThan(Byte value) {
            addCriterion("ast >", value, "ast");
            return (Criteria) this;
        }

        public Criteria andAstGreaterThanOrEqualTo(Byte value) {
            addCriterion("ast >=", value, "ast");
            return (Criteria) this;
        }

        public Criteria andAstLessThan(Byte value) {
            addCriterion("ast <", value, "ast");
            return (Criteria) this;
        }

        public Criteria andAstLessThanOrEqualTo(Byte value) {
            addCriterion("ast <=", value, "ast");
            return (Criteria) this;
        }

        public Criteria andAstIn(List<Byte> values) {
            addCriterion("ast in", values, "ast");
            return (Criteria) this;
        }

        public Criteria andAstNotIn(List<Byte> values) {
            addCriterion("ast not in", values, "ast");
            return (Criteria) this;
        }

        public Criteria andAstBetween(Byte value1, Byte value2) {
            addCriterion("ast between", value1, value2, "ast");
            return (Criteria) this;
        }

        public Criteria andAstNotBetween(Byte value1, Byte value2) {
            addCriterion("ast not between", value1, value2, "ast");
            return (Criteria) this;
        }

        public Criteria andStlIsNull() {
            addCriterion("stl is null");
            return (Criteria) this;
        }

        public Criteria andStlIsNotNull() {
            addCriterion("stl is not null");
            return (Criteria) this;
        }

        public Criteria andStlEqualTo(Byte value) {
            addCriterion("stl =", value, "stl");
            return (Criteria) this;
        }

        public Criteria andStlNotEqualTo(Byte value) {
            addCriterion("stl <>", value, "stl");
            return (Criteria) this;
        }

        public Criteria andStlGreaterThan(Byte value) {
            addCriterion("stl >", value, "stl");
            return (Criteria) this;
        }

        public Criteria andStlGreaterThanOrEqualTo(Byte value) {
            addCriterion("stl >=", value, "stl");
            return (Criteria) this;
        }

        public Criteria andStlLessThan(Byte value) {
            addCriterion("stl <", value, "stl");
            return (Criteria) this;
        }

        public Criteria andStlLessThanOrEqualTo(Byte value) {
            addCriterion("stl <=", value, "stl");
            return (Criteria) this;
        }

        public Criteria andStlIn(List<Byte> values) {
            addCriterion("stl in", values, "stl");
            return (Criteria) this;
        }

        public Criteria andStlNotIn(List<Byte> values) {
            addCriterion("stl not in", values, "stl");
            return (Criteria) this;
        }

        public Criteria andStlBetween(Byte value1, Byte value2) {
            addCriterion("stl between", value1, value2, "stl");
            return (Criteria) this;
        }

        public Criteria andStlNotBetween(Byte value1, Byte value2) {
            addCriterion("stl not between", value1, value2, "stl");
            return (Criteria) this;
        }

        public Criteria andBlkIsNull() {
            addCriterion("blk is null");
            return (Criteria) this;
        }

        public Criteria andBlkIsNotNull() {
            addCriterion("blk is not null");
            return (Criteria) this;
        }

        public Criteria andBlkEqualTo(Byte value) {
            addCriterion("blk =", value, "blk");
            return (Criteria) this;
        }

        public Criteria andBlkNotEqualTo(Byte value) {
            addCriterion("blk <>", value, "blk");
            return (Criteria) this;
        }

        public Criteria andBlkGreaterThan(Byte value) {
            addCriterion("blk >", value, "blk");
            return (Criteria) this;
        }

        public Criteria andBlkGreaterThanOrEqualTo(Byte value) {
            addCriterion("blk >=", value, "blk");
            return (Criteria) this;
        }

        public Criteria andBlkLessThan(Byte value) {
            addCriterion("blk <", value, "blk");
            return (Criteria) this;
        }

        public Criteria andBlkLessThanOrEqualTo(Byte value) {
            addCriterion("blk <=", value, "blk");
            return (Criteria) this;
        }

        public Criteria andBlkIn(List<Byte> values) {
            addCriterion("blk in", values, "blk");
            return (Criteria) this;
        }

        public Criteria andBlkNotIn(List<Byte> values) {
            addCriterion("blk not in", values, "blk");
            return (Criteria) this;
        }

        public Criteria andBlkBetween(Byte value1, Byte value2) {
            addCriterion("blk between", value1, value2, "blk");
            return (Criteria) this;
        }

        public Criteria andBlkNotBetween(Byte value1, Byte value2) {
            addCriterion("blk not between", value1, value2, "blk");
            return (Criteria) this;
        }

        public Criteria andToIsNull() {
            addCriterion("to is null");
            return (Criteria) this;
        }

        public Criteria andToIsNotNull() {
            addCriterion("to is not null");
            return (Criteria) this;
        }

        public Criteria andToEqualTo(Byte value) {
            addCriterion("to =", value, "to");
            return (Criteria) this;
        }

        public Criteria andToNotEqualTo(Byte value) {
            addCriterion("to <>", value, "to");
            return (Criteria) this;
        }

        public Criteria andToGreaterThan(Byte value) {
            addCriterion("to >", value, "to");
            return (Criteria) this;
        }

        public Criteria andToGreaterThanOrEqualTo(Byte value) {
            addCriterion("to >=", value, "to");
            return (Criteria) this;
        }

        public Criteria andToLessThan(Byte value) {
            addCriterion("to <", value, "to");
            return (Criteria) this;
        }

        public Criteria andToLessThanOrEqualTo(Byte value) {
            addCriterion("to <=", value, "to");
            return (Criteria) this;
        }

        public Criteria andToIn(List<Byte> values) {
            addCriterion("to in", values, "to");
            return (Criteria) this;
        }

        public Criteria andToNotIn(List<Byte> values) {
            addCriterion("to not in", values, "to");
            return (Criteria) this;
        }

        public Criteria andToBetween(Byte value1, Byte value2) {
            addCriterion("to between", value1, value2, "to");
            return (Criteria) this;
        }

        public Criteria andToNotBetween(Byte value1, Byte value2) {
            addCriterion("to not between", value1, value2, "to");
            return (Criteria) this;
        }

        public Criteria andPfIsNull() {
            addCriterion("pf is null");
            return (Criteria) this;
        }

        public Criteria andPfIsNotNull() {
            addCriterion("pf is not null");
            return (Criteria) this;
        }

        public Criteria andPfEqualTo(Byte value) {
            addCriterion("pf =", value, "pf");
            return (Criteria) this;
        }

        public Criteria andPfNotEqualTo(Byte value) {
            addCriterion("pf <>", value, "pf");
            return (Criteria) this;
        }

        public Criteria andPfGreaterThan(Byte value) {
            addCriterion("pf >", value, "pf");
            return (Criteria) this;
        }

        public Criteria andPfGreaterThanOrEqualTo(Byte value) {
            addCriterion("pf >=", value, "pf");
            return (Criteria) this;
        }

        public Criteria andPfLessThan(Byte value) {
            addCriterion("pf <", value, "pf");
            return (Criteria) this;
        }

        public Criteria andPfLessThanOrEqualTo(Byte value) {
            addCriterion("pf <=", value, "pf");
            return (Criteria) this;
        }

        public Criteria andPfIn(List<Byte> values) {
            addCriterion("pf in", values, "pf");
            return (Criteria) this;
        }

        public Criteria andPfNotIn(List<Byte> values) {
            addCriterion("pf not in", values, "pf");
            return (Criteria) this;
        }

        public Criteria andPfBetween(Byte value1, Byte value2) {
            addCriterion("pf between", value1, value2, "pf");
            return (Criteria) this;
        }

        public Criteria andPfNotBetween(Byte value1, Byte value2) {
            addCriterion("pf not between", value1, value2, "pf");
            return (Criteria) this;
        }

        public Criteria andPtsIsNull() {
            addCriterion("pts is null");
            return (Criteria) this;
        }

        public Criteria andPtsIsNotNull() {
            addCriterion("pts is not null");
            return (Criteria) this;
        }

        public Criteria andPtsEqualTo(Byte value) {
            addCriterion("pts =", value, "pts");
            return (Criteria) this;
        }

        public Criteria andPtsNotEqualTo(Byte value) {
            addCriterion("pts <>", value, "pts");
            return (Criteria) this;
        }

        public Criteria andPtsGreaterThan(Byte value) {
            addCriterion("pts >", value, "pts");
            return (Criteria) this;
        }

        public Criteria andPtsGreaterThanOrEqualTo(Byte value) {
            addCriterion("pts >=", value, "pts");
            return (Criteria) this;
        }

        public Criteria andPtsLessThan(Byte value) {
            addCriterion("pts <", value, "pts");
            return (Criteria) this;
        }

        public Criteria andPtsLessThanOrEqualTo(Byte value) {
            addCriterion("pts <=", value, "pts");
            return (Criteria) this;
        }

        public Criteria andPtsIn(List<Byte> values) {
            addCriterion("pts in", values, "pts");
            return (Criteria) this;
        }

        public Criteria andPtsNotIn(List<Byte> values) {
            addCriterion("pts not in", values, "pts");
            return (Criteria) this;
        }

        public Criteria andPtsBetween(Byte value1, Byte value2) {
            addCriterion("pts between", value1, value2, "pts");
            return (Criteria) this;
        }

        public Criteria andPtsNotBetween(Byte value1, Byte value2) {
            addCriterion("pts not between", value1, value2, "pts");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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