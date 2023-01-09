package com.example.fgoapp

import java.io.Serializable

class ServantDump : ArrayList<ServantDump.ServantDumpItem>() , Serializable{
    data class ServantDumpItem(
        val name: String,
        val id: Int,
        val atkBase: Int,
        val atkGrowth: List<Int>,
        val atkMax: Int,
        val attribute: String,
        val battleName: String,
        val cards: List<String>,
        val className: String,
        val collectionNo: Int,
        val growthCurve: Int,
        val hitsDistribution: HitsDistribution,
        val noblePhantasms: List<NoblePhantasm>,
        val originalBattleName: String,
        val originalName: String,
        val rarity: Int,
        val type: String,
    ) : Serializable {
        data class CardDetails(
            val arts: Arts,
            val buster: Buster,
            val extra: Extra,
            val quick: Quick
        ) : Serializable {
            data class Arts(
                val attackIndividuality: List<AttackIndividuality>
            ) : Serializable {
                data class AttackIndividuality(
                    val id: Int,
                    val name: String
                ) : Serializable
            }

            data class Buster(
                val attackIndividuality: List<AttackIndividuality>
            ) : Serializable {
                data class AttackIndividuality(
                    val id: Int,
                    val name: String
                ) : Serializable
            }

            data class Extra(
                val attackIndividuality: List<AttackIndividuality>
            ) : Serializable {
                data class AttackIndividuality(
                    val id: Int,
                    val name: String
                ) : Serializable
            }

            data class Quick(
                val attackIndividuality: List<AttackIndividuality>
            ) : Serializable {
                data class AttackIndividuality(
                    val id: Int,
                    val name: String
                ) : Serializable
            }
        }

        data class HitsDistribution(
            val arts: List<Int>,
            val buster: List<Int>,
            val extra: List<Int>,
            val quick: List<Int>
        ) : Serializable

        data class NoblePhantasm(
            val card: String,
            val condQuestId: Int,
            val condQuestPhase: Int,
            val detail: String,
            val effectFlags: List<String>,
            val functions: List<Function>,
            val icon: String,
            val id: Int,
            val individuality: List<Individuality>,
            val name: String,
            val npDistribution: List<Int>,
            val npGain: NpGain,
            val num: Int,
            val originalName: String,
            val priority: Int,
            val rank: String,
            val ruby: String,
            val script: Script,
            val strengthStatus: Int,
            val type: String,
            val unmodifiedDetail: String
        ) : Serializable {
            data class Function(
                val buffs: List<Any>,
                val funcGroup: List<Any>,
                val funcId: Int,
                val funcPopupText: String,
                val funcTargetTeam: String,
                val funcTargetType: String,
                val funcType: String,
                val funcquestTvals: List<Any>,
                val functvals: List<Any>,
                val svals: List<Sval>,
                val svals2: List<Svals2>,
                val svals3: List<Svals3>,
                val svals4: List<Svals4>,
                val svals5: List<Svals5>
            ) : Serializable {
                data class Sval(
                    val Rate: Int,
                    val Value: Int
                ) : Serializable

                data class Svals2(
                    val Rate: Int,
                    val Value: Int
                ) : Serializable

                data class Svals3(
                    val Rate: Int,
                    val Value: Int
                ) : Serializable

                data class Svals4(
                    val Rate: Int,
                    val Value: Int
                ) : Serializable

                data class Svals5(
                    val Rate: Int,
                    val Value: Int
                ) : Serializable
            }

            data class Individuality(
                val id: Int,
                val name: String
            ) : Serializable

            data class NpGain(
                val arts: List<Int>,
                val buster: List<Int>,
                val defence: List<Int>,
                val extra: List<Int>,
                val np: List<Int>,
                val quick: List<Int>
            ) : Serializable

            class Script : Serializable
        }
    }
}