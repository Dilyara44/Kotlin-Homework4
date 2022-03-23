package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun main() {
    }

    @Test
    fun countCommission_NoCommissionForMastercard() {
        val typeOfCard = "MasterCard"

        val sumOfPreviousTransfers = 4500.00
        val transactionSum = 13456.00

        val result = countCommission(typeOfCard, sumOfPreviousTransfers, transactionSum)

        assertEquals(0.00, result, 0.00001)
    }

    @Test
    fun countCommission_NoCommissionForMaestro() {
        val typeOfCard = "Maestro"
        val sumOfPreviousTransfers = 4500.00
        val transactionSum = 13456.00

        val result = countCommission(typeOfCard, sumOfPreviousTransfers, transactionSum)

        assertEquals(0.00, result, 0.00001)
    }

    @Test
    fun countCommission_CommissionForMastercard() {
        val typeOfCard = "MasterCard"
        val sumOfPreviousTransfers = 45000.00
        val transactionSum = 45000.00

        val result = countCommission(typeOfCard, sumOfPreviousTransfers, transactionSum)

        assertEquals(290.00, result, 0.00001)
    }

    @Test
    fun countCommission_CommissionForMaestro() {
        val typeOfCard = "Maestro"
        val sumOfPreviousTransfers = 45000.00
        val transactionSum = 45000.00

        val result = countCommission(typeOfCard, sumOfPreviousTransfers, transactionSum)

        assertEquals(290.00, result, 0.00001)
    }

    @Test
    fun countCommission_StandardCommissionForVisa() {
        val typeOfCard = "VISA"
        val sumOfPreviousTransfers = 4500.00
        val transactionSum = 6000.00

        val result = countCommission(typeOfCard, sumOfPreviousTransfers, transactionSum)

        assertEquals(45.00, result, 0.00001)
    }

    @Test
    fun countCommission_StandardCommissionForMir() {
        val typeOfCard = "Мир"
        val sumOfPreviousTransfers = 4500.00
        val transactionSum = 6000.00

        val result = countCommission(typeOfCard, sumOfPreviousTransfers, transactionSum)

        assertEquals(45.00, result, 0.00001)
    }

    @Test
    fun countCommission_MinCommissionForVisa() {
        val typeOfCard = "VISA"
        val sumOfPreviousTransfers = 4500.00
        val transactionSum = 2000.00

        val result = countCommission(typeOfCard, sumOfPreviousTransfers, transactionSum)

        assertEquals(35.00, result, 0.00001)
    }

    @Test
    fun countCommission_MinCommissionForMir() {
        val typeOfCard = "Мир"
        val sumOfPreviousTransfers = 4500.00
        val transactionSum = 2000.00

        val result = countCommission(typeOfCard, sumOfPreviousTransfers, transactionSum)

        assertEquals(35.00, result, 0.00001)
    }

    @Test
    fun countCommission_CommissionForVKPay() {

        val result = countCommission(sumOfPreviousTransfers = 123752.00, transactionSum = 2000.00)
        assertEquals(0.00, result, 0.00001)
    }

    @Test
    fun countCommission_withoutPreviousBuys() {

        val result = countCommission(typeOfCard = "Мир", transactionSum = 2000.00)
        assertEquals(35.00, result, 0.00001)
    }

    @Test
    fun countCommission_MinCommissionForVisa_Fail() {
        val typeOfCard = "VISA"
        val sumOfPreviousTransfers = 4500.00
        val transactionSum = 2000.00

        val result = countCommission(typeOfCard, sumOfPreviousTransfers, transactionSum)

        assertEquals(3522.00, result, 0.00001)
    }
}