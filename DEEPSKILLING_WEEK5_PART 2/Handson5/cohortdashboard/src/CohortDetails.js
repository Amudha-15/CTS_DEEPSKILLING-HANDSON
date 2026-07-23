import React from "react";
import styles from "./CohortDetails.module.css";

function CohortDetails(props) {

    const statusStyle =
        props.status === "Ongoing"
            ? styles.ongoing
            : styles.completed;

    return (
        <div className={styles.box}>
            <h3 className={statusStyle}>{props.status}</h3>

            <dl>
                <dt>Cohort Code</dt>
                <dd>{props.code}</dd>

                <dt>Technology</dt>
                <dd>{props.technology}</dd>

                <dt>Trainer</dt>
                <dd>{props.trainer}</dd>

                <dt>Coach</dt>
                <dd>{props.coach}</dd>

                <dt>Start Date</dt>
                <dd>{props.startDate}</dd>

                <dt>Current Status</dt>
                <dd>{props.status}</dd>
            </dl>
        </div>
    );
}

export default CohortDetails;