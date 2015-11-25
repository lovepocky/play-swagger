package instagram.api.yaml
import play.api.mvc.{Action, Controller}
import play.api.data.validation.Constraint
import de.zalando.play.controllers._
import PlayBodyParsing._
import PlayValidations._

object parametersAction {
    import parameters.`User-id-paramUser-id`
    import parameters.`Tag-nameTag-name`
    }
object definitionsAction {
    import definitions._
    }
object pathsAction {
    import definitions._
    import paths._
    import definitionsAction._
    class InstagramApiYaml extends InstagramApiYamlBase {
        val getUsersSearch = getUsersSearchAction {
            input: (String, LikeUser_name) =>
            val (q, count) = input
            
            ???
        }
        val getUsersSelfMediaLiked = getUsersSelfMediaLikedAction {
            input: (MediaCreated_time, MediaCreated_time) =>
            val (count, max_like_id) = input
            
            ???
        }
        val getTagsSearch = getTagsSearchAction {
            (q: LikeUser_name) =>
            ???
        }
        val getUsersSelfFeed = getUsersSelfFeedAction {
            input: (MediaCreated_time, MediaCreated_time, MediaCreated_time) =>
            val (count, max_id, min_id) = input
            
            ???
        }
        val getMediaSearch = getMediaSearchAction {
            input: (MediaCreated_time, MediaCreated_time, LocationLongitude, MediaCreated_time, LocationLongitude) =>
            val (mAX_TIMESTAMP, dISTANCE, lNG, mIN_TIMESTAMP, lAT) = input
            
            ???
        }
        val getMediaByShortcode = getMediaByShortcodeAction {
            (shortcode: String) =>
            ???
        }
        val getLocationsSearch = getLocationsSearchAction {
            input: (MediaCreated_time, MediaCreated_time, MediaCreated_time, LocationLongitude, MediaCreated_time, LocationLongitude) =>
            val (foursquare_v2_id, facebook_places_id, distance, lat, foursquare_id, lng) = input
            
            ???
        }
        val getMediaPopular = getMediaPopularAction {
            
            ???
        }
        }
    }
