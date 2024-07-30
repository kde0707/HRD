package org.chulgang.hrd.payment.model.service;


import org.chulgang.hrd.payment.dto.PaymentCardResponse;
import org.chulgang.hrd.payment.model.repository.PaymentRepository;
import org.chulgang.hrd.payment.model.repository.PaymentRepositoryImpl;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    private static final PaymentServiceImpl INSTANCE = new PaymentServiceImpl(PaymentRepositoryImpl.getInstance());
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public static PaymentServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean executePayment(Long memberId, Long reservationId, int paymentAmount) {
        return paymentRepository.executePayment(memberId, reservationId, paymentAmount);
    }

    @Override
    public List<PaymentCardResponse> getPagedPayments(Long userId, int pageNumber) {
        return paymentRepository.findPaymentCourseCardByMemberId(userId, pageNumber);
    }
}
