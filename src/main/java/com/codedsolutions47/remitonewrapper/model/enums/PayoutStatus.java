package com.codedsolutions47.remitonewrapper.model.enums;

public enum PayoutStatus {
    PENDING_CLEARANCE("Transaction has been created in the system but the remitter has not paid for transaction. Awaiting payment before transaction will be ready for processing."),
    ENTERED("Transaction awaiting approval by sending agent before processing."),
    AGENT_OK("Transaction awaiting HQ approval or routing before processing."),
    HQ_READY("Transaction has been approved by HQ and will be sent to processing bank/agent in the next batch. This only applies if you are using batch processing."),
    HQ_OK("Transaction awaiting processing bank/agent approval before ready for processing."),
    HQ_OK_PAID("Transaction awaiting processing bank/agent approval before ready for processing but transaction has been credited to processing bank/agent already. This status only applies in error correction scenarios."),
    SENT_FOR_PAY("Transaction ready to be paid out by processing bank/agent."),
    SENT_FOR_DELIVERY("Transaction ready to be paid out by processing bank/agent branch."),
    PROCESSED("Transaction has been processed."),
    ABORTED("Transaction has been accepted by processing bank/agent but now it has been requested to be cancelled. Awaiting processing bank/agent approval for cancellation or rejection of cancellation request."),
    ERROR("Transaction has some problem with it and is going through error correction cycle."),
    DELETED("Transaction has been cancelled.");

    private final String description;

    PayoutStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
