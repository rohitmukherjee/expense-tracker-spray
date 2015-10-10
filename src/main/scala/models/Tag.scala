package models

import spray.json.DefaultJsonProtocol

case class Tag(id: Int, name: String)

object TagCompanion extends DefaultJsonProtocol {
  implicit def toJson = jsonFormat2(Tag.apply)
}