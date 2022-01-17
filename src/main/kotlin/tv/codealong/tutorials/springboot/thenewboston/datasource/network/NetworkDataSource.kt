package tv.codealong.tutorials.springboot.thenewboston.datasource.network

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import org.springframework.web.client.getForObject
import tv.codealong.tutorials.springboot.thenewboston.datasource.BankDataSource
//import tv.codealong.tutorials.springboot.thenewboston.datasource.BankDataSource
import tv.codealong.tutorials.springboot.thenewboston.datasource.network.dto.BankList
import tv.codealong.tutorials.springboot.thenewboston.model.Bank
import java.io.IOException

@Repository("network")
class NetworkDataSource(
    @Autowired private val restTemplate: RestTemplate
) : BankDataSource {

    override fun retrieveBanks(): List<Bank> {
        // NOTE: create / clone your own endpoint here: https://61e037d70f3bdb0017934eb4.mockapi.io/api/

        val response: ResponseEntity<List<Bank>> =
            restTemplate.getForEntity("https://61e037d70f3bdb0017934eb4.mockapi.io/api/banks")

        //val response: ResponseEntity<BankList> =
        //    restTemplate.getForEntity("https://61e037d70f3bdb0017934eb4.mockapi.io/api/banks")

        return response.body //?.results
            ?: throw IOException("Could not fetch banks from the network")
    }

    override fun retrieveBank(accountNumber: String): Bank {
        TODO("Not yet implemented")
    }

    override fun createBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun updateBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun deleteBank(accountNumber: String) {
        TODO("Not yet implemented")
    }
}