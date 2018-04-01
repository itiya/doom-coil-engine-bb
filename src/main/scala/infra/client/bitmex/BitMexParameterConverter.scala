package infra.client.bitmex

import java.security.InvalidParameterException

import domain.client.order.Side.{Buy, Sell}
import domain.client.order.{Side, TimeInForce}
import domain.client.order.TimeInForce.{FOK, GTC, IOC}
import infra.client.ProductCode
import infra.client.bitmex.BitMexProductCode.BtcUsdFx

object BitMexParameterConverter {
  def productCode(productCode: ProductCode): String =
    productCode match {
      case BtcUsdFx => "XBTUSD"
      case _ => throw new InvalidParameterException("invalid product code for bitflyer")
    }

  def side(side: Side): String =
    side match {
      case Buy => "Buy"
      case Sell => "Sell"
    }

  def timeInForce(timeInForce: TimeInForce): String =
    timeInForce match {
      case GTC => "GTC"
      case IOC => "IOC"
      case FOK => "FOK"
      case _ => throw new InvalidParameterException("invalid time in force for bitflyer")
    }
}
